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
 * Entity for Category table.
 *
 * @author Rugal Bernstein
 */
@Data
@Entity
@Table(schema = SCHEMA, name = "category")
public class Category {

  private static final String SEQUENCE_NAME = "category_cid_seq";

  @Basic(optional = false)
  @Column
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
  @Id
  @SequenceGenerator(name = SEQUENCE_NAME, allocationSize = 1,
                     sequenceName = SCHEMA + "." + SEQUENCE_NAME)
  private Integer cid;

  @Size(max = 50)
  @Column
  private String name;

  @Size(max = 100)
  @Column
  private String description;
}
