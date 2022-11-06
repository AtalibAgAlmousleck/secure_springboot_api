package com.almousleck.apiapplication.resource;

import com.almousleck.apiapplication.model.Account;
import com.almousleck.apiapplication.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.almousleck.apiapplication.resource.EmployeeResource.getLocation;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountResource {

    private final AccountService accountService;

    @PostMapping()
    public ResponseEntity<Account> creatAccount(@RequestBody Account account) {
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.created(getLocation(newAccount.getId().intValue())).body(newAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {
        return ResponseEntity.ok(accountService.getAccounts());
    }
}
