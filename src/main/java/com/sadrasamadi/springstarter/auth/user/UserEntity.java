package com.sadrasamadi.springstarter.auth.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sadrasamadi.springstarter.core.CoreEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends CoreEntity {

  @Column(unique = true)
  private String username;

  @Column(unique = true)
  private String email;

  @Column
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @JoinColumn
  @ManyToOne(fetch = FetchType.EAGER)
  private RoleEntity role;

  @Column
  @Enumerated(EnumType.STRING)
  private Status status;

  public enum Status {

    INACTIVE,

    ACTIVE

  }

}
