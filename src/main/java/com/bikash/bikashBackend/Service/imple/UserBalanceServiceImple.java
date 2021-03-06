package com.bikash.bikashBackend.Service.imple;

import com.bikash.bikashBackend.Model.UserBalance;
import com.bikash.bikashBackend.Service.UserBalanceService;
import com.bikash.bikashBackend.repository.UserBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("userBalanceService")
public class UserBalanceServiceImple implements UserBalanceService {
    private final UserBalanceRepository userBalanceRepository;

    @Autowired
    public UserBalanceServiceImple(UserBalanceRepository userBalanceRepository) {
        this.userBalanceRepository = userBalanceRepository;
    }

    @Override
    public UserBalance create(Long userId, double balance, Date createdAt) {
        if (balance == 0) {

        }
        UserBalance userBalance = new UserBalance();
        userBalance.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        userBalance.setCreatedAt(createdAt);
        userBalance.setUserId(userId);
        userBalance.setBalance(balance);
        userBalance = userBalanceRepository.save(userBalance);
        if (userBalance != null) {
            return userBalance;
        }
        return null;
    }

    @Override
    public UserBalance update(Long userId, double balance, Date updatedAt) {//for increased balanced
        UserBalance haveUser = userBalanceRepository.findUserBalanceByUserIdAndIsActiveTrue(userId);
        if (haveUser != null) {
            haveUser.setBalance(haveUser.getBalance() + balance);
            haveUser.setUpdatedAt(updatedAt);
            haveUser.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
            UserBalance userBalance = userBalanceRepository.save(haveUser);
            if (userBalance != null) {
                return userBalance;
            }
            return null;
        }
        return null;
    }

    @Override
    public UserBalance consumeBalUpdate(Long userId, double balance, Date updatedAt) {
        UserBalance haveUser = userBalanceRepository.findUserBalanceByUserIdAndIsActiveTrue(userId);
        if (haveUser != null) {
            haveUser.setBalance(haveUser.getBalance() - balance);//consume here
            haveUser.setUpdatedAt(updatedAt);
            haveUser.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
            UserBalance userBalance = userBalanceRepository.save(haveUser);
            if (userBalance != null) {
                return userBalance;
            }
            return null;
        }
        return null;
    }
}
