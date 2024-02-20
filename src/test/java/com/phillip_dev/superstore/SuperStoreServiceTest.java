package com.phillip_dev.superstore;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.phillip_dev.superstore.repository.SuperStoreRepository;
import com.phillip_dev.superstore.service.SuperStoreService;

@RunWith(MockitoJUnitRunner.class)
public class SuperStoreServiceTest {

    @Mock
    private SuperStoreRepository superStoreRepository;

    @InjectMocks
    private SuperStoreService superStoreService;
    
}
