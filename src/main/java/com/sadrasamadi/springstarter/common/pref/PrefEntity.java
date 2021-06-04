package com.sadrasamadi.springstarter.common.pref;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prefs")
public class PrefEntity {

  @Id
  private String key;

  @Column
  private String type;

  @Column
  private String value;

}
