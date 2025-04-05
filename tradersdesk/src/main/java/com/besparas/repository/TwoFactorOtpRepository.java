package com.besparas.repository;

import com.besparas.modal.TwoFactorOTP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwoFactorOtpRepository  extends JpaRepository<TwoFactorOTP, String> {

    TwoFactorOTP findByUserId(Long UserId);


}
