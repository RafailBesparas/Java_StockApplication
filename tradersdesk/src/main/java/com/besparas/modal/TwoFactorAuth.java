package com.besparas.modal;

import com.besparas.domain.verificationType;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class TwoFactorAuth {
    private boolean isEnabled  = false;
    private verificationType sendTo;
}
