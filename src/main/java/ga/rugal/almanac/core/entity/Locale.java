package ga.rugal.almanac.core.entity;

import static config.SystemDefaultProperty.SCHEMA;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Entity for Locale table.
 *
 * @author Rugal Bernstein
 */
@Data
@Entity
@Table(schema = SCHEMA, name = "locale")
public class Locale {

  private static final String SEQUENCE_NAME = "locale_lid_seq";

  @Basic(optional = false)
  @Column
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
  @Id
  @SequenceGenerator(name = SEQUENCE_NAME, allocationSize = 1,
                     sequenceName = SCHEMA + "." + SEQUENCE_NAME)
  private Integer lid;

  @Size(max = 20)
  @Column
  private String language;

  @Size(max = 20)
  @Column
  private String country;
}
