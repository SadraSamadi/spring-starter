package com.sadrasamadi.springstarter.common.asset;

import com.sadrasamadi.springstarter.auth.prop.PropEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assets")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AssetEntity extends PropEntity {

  @Column
  @Enumerated(EnumType.STRING)
  private Location location;

  @Column
  private String name;

  @Column
  private String type;

  @Column
  private String hash;

  @Column
  private String ext;

  @Column
  private String uri;

  public enum Location {

    INTERNAL,

    EXTERNAL

  }

}
