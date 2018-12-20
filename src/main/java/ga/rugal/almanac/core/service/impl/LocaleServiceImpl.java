package ga.rugal.almanac.core.service.impl;

import ga.rugal.almanac.core.dao.LocaleDao;
import ga.rugal.almanac.core.service.LocaleService;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocaleServiceImpl implements LocaleService {

  @Autowired
  @Getter
  @Setter
  private LocaleDao dao;
}
