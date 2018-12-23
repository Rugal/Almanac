package ga.rugal.almanac.core.entity;

import static config.SystemDefaultProperty.SCHEMA;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Entity for Placeholder table.
 *
 * @author Rugal Bernstein
 */
@Data
@Entity
@Table(schema = SCHEMA, name = "placeholder")
public class Placeholder {

  private static final String SEQUENCE_NAME = "placeholder_pid_seq";

  @Basic(optional = false)
  @Column
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
  @Id
  @SequenceGenerator(name = SEQUENCE_NAME, allocationSize = 1,
                     sequenceName = SCHEMA + "." + SEQUENCE_NAME)
  private Integer pid;

  @Size(max = 50)
  @Column
  private String name;

  @JoinColumn(name = "cid", referencedColumnName = "cid")
  @ManyToOne
  private Category category;
}
