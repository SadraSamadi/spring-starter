package com.sadrasamadi.springstarter.auth.user;

import com.sadrasamadi.springstarter.core.CoreEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "permissions")
@EqualsAndHashCode(callSuper = true)
public class PermissionEntity extends CoreEntity {

  @JoinColumn
  @ManyToOne(fetch = FetchType.LAZY)
  private RoleEntity role;

  @Column
  public String feature;

  @Column
  public String action;

  @Column
  public boolean granted;

  @Column
  public boolean limited;

}
