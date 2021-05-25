package com.sadrasamadi.springstarter.auth.prop;

import com.sadrasamadi.springstarter.auth.user.UserEntity;
import com.sadrasamadi.springstarter.core.CoreEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Data
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PropEntity extends CoreEntity {

  @ManyToOne
  @JoinColumn
  private UserEntity owner;

}
