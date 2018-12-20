package ga.rugal.almanac.core.service.impl;

import ga.rugal.almanac.core.dao.TranslationDao;
import ga.rugal.almanac.core.service.TranslationService;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationServiceImpl implements TranslationService {

  @Autowired
  @Getter
  @Setter
  private TranslationDao dao;
}
