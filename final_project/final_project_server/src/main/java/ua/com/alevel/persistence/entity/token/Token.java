package ua.com.alevel.persistence.entity.token;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.type.TokenType;

@Getter
@Setter
@Entity
@Builder
@Table(name = "token")
@AllArgsConstructor
public class Token extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "token_type")
    private TokenType tokenType;

    private Boolean expired;
    private Boolean revoked;

    @OneToOne
    private User user;

    public Token() {
        this.tokenType = TokenType.BEARER;
    }
}
