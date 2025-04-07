package com.besparas.service;

import com.besparas.modal.User;

public interface UserService {

    public User findUserProfileByJwt(String jwt);
}
