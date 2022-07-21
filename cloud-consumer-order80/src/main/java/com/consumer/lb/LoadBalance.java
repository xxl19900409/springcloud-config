package com.consumer.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {

    public ServiceInstance getServiceInstance(List<ServiceInstance> instances);
}
