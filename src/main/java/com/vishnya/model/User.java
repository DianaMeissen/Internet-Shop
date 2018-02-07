package com.vishnya.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(generator = "USER_GEN")
    @SequenceGenerator(name = "USER_GEN", sequenceName = "USER_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "ACTIVATION_TOKEN")
    private String activationToken;
    @Enumerated(STRING)
    @Column(name = "ACCOUNT_STATUS")
    private AccountStatus status;
    @Column(name = "REGISTER_DATE")
    private LocalDateTime registerDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<ProductOrder> productOrders = new ArrayList<>();

    public User() {}

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrders.add(productOrder);
        productOrder.setUser(this);
    }

    public enum AccountStatus {
        PENDING_ACTIVATION,
        ACTIVE,
        BLOCKED
    }
}


