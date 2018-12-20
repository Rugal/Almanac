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
 * Entity for Translation table.
 *
 * @author Rugal Bernstein
 */
@Data
@Entity
@Table(schema = SCHEMA, name = "translation")
public class Translation {

  private static final String SEQUENCE_NAME = "translation_tid_seq";

  @Basic(optional = false)
  @Column
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
  @Id
  @SequenceGenerator(name = SEQUENCE_NAME, allocationSize = 1,
                     sequenceName = SCHEMA + "." + SEQUENCE_NAME)
  private Integer tid;

  @Column(name = "is_aspicious")
  private Boolean aspicious;

  @Column
  @Size(max = 100)
  private String content;

  @JoinColumn(name = "hid", referencedColumnName = "hid")
  @ManyToOne
  private Hexagram hexagram;

  @JoinColumn(name = "lid", referencedColumnName = "lid")
  @ManyToOne
  private Locale locale;
}
