package com.vishnya.services;

import com.vishnya.model.User;

public interface NotificationService {
    void sendAccountActivation(User user);
}
