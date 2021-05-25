package com.sadrasamadi.springstarter.app.post;

import com.sadrasamadi.springstarter.auth.prop.PropEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PostEntity extends PropEntity {

  @Column
  private String title;

  @Column
  private String body;

}
