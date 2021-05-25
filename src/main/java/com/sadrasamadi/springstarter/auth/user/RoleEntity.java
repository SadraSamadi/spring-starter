package com.sadrasamadi.springstarter.auth.user;

import com.sadrasamadi.springstarter.core.CoreEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RoleEntity extends CoreEntity {

  @Column(unique = true)
  private String name;

  @JoinColumn(name = "role_id")
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<PermissionEntity> permissions;

}
