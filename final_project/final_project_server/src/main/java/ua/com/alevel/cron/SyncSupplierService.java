package ua.com.alevel.cron;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SyncSupplierService {

    @Value("${supplier.key}")
    private String supplierKey;

    @Value("${supplier.host}")
    private String supplierHost;

    @Scheduled(cron = "*/10 * * * * *")
    public void synchronizedProduct() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("auth-token", supplierKey);

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                supplierHost, HttpMethod.GET, requestEntity, String.class);

        if (responseEntity.getStatusCode().is4xxClientError()) {
            System.out.println("responseEntity = " + responseEntity.getStatusCode().value());
        }
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("response = " + responseEntity.getBody());
        }
    }
}
