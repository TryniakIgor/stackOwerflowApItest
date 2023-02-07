package com.example.stackOwerflowAPItest.service;

import com.example.stackOwerflowAPItest.dto.UserDTO;
import com.example.stackOwerflowAPItest.mapper.UserMapper;
import com.example.stackOwerflowAPItest.model.Root;
import com.example.stackOwerflowAPItest.model.User;
import lombok.SneakyThrows;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {
    RequestConfig requestConfig = RequestConfig.custom()
            .setCookieSpec(CookieSpecs.STANDARD)
            .build();
    HttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

    ClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

    @SneakyThrows
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        int page = 0;
        while (true) {
            page++;
            String url = "https://api.stackexchange.com/2.3/users?page=" + page + "&pagesize=100&order=desc&max=999&sort=reputation&site=stackoverflow&filter=!LnOc4qFtGwuDdjMU8Ntkd.";
            Root response = restTemplate.getForObject(new URI(url), Root.class);
            users.addAll(response.getItems());

            /**
             * right condition is if (!response.isHas_more())
             * but Stack Extange has a selection limit of 25 pages
             */
            if (page == 25) {
                break;
            }
        }
        return users;
    }

    public List<UserDTO> filter(List<User> list) {

        return list.stream()
                .filter(user -> user.getAnswer_count() > 0 && user.getLocation().contains("Moldova") || user.getLocation().contains("Romania"))
                .filter(user -> user.getReputation() > 223 && user.getAnswer_count() > 1)
                .filter(user -> user.getCollectives().get(0).getCollective().getTags().contains("java") && user.getCollectives().get(0).getCollective().getTags().contains("net") && user.getCollectives().get(0).getCollective().getTags().contains("docker") && user.getCollectives().get(0).getCollective().getTags().contains("C#"))
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<UserDTO> testFilter(List<User> list) {
        return list.stream()
                .filter(user -> user.getAnswer_count() > 0 && user.getLocation().contains("London") || user.getLocation().contains("USA") )
                .filter(user -> user.getReputation() > 223 && user.getAnswer_count() > 1)
                .filter(user -> user.getCollectives().get(0).getCollective().getTags().contains("amazon"))
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<UserDTO> result() {
        return filter(getUsers());
    }

    public List<UserDTO> testResult() {
        return testFilter(getUsers());
    }

}
