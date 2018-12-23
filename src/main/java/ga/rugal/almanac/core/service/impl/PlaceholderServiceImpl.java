package ga.rugal.almanac.core.service.impl;

import ga.rugal.almanac.core.dao.PlaceholderDao;
import ga.rugal.almanac.core.service.PlaceholderService;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation for filling placeholder of explanation.
 *
 * @author Rugal Bernstein
 */
@Service
public class PlaceholderServiceImpl implements PlaceholderService {

  @Autowired
  @Getter
  @Setter
  private PlaceholderDao dao;
}
