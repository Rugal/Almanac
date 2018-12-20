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

import lombok.Data;

/**
 * Entity for Hexagram table.
 *
 * @author Rugal Bernstein
 */
@Data
@Entity
@Table(schema = SCHEMA, name = "hexagram")
public class Hexagram {

  private static final String SEQUENCE_NAME = "hexagram_hid_seq";

  @Basic(optional = false)
  @Column
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
  @Id
  @SequenceGenerator(name = SEQUENCE_NAME, allocationSize = 1,
                     sequenceName = SCHEMA + "." + SEQUENCE_NAME)
  private Integer hid;

  @Column
  private Boolean weekend;

  @JoinColumn(name = "cid", referencedColumnName = "cid")
  @ManyToOne
  private Category category;
}
