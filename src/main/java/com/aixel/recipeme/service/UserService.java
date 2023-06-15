package com.aixel.recipeme.service;

import com.aixel.recipeme.document.UserDocument;
import com.aixel.recipeme.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDocument> findAll() {
        return userRepository.findAll();
    }
}
