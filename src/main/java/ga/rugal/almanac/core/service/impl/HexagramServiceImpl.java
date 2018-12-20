package ga.rugal.almanac.core.service.impl;

import ga.rugal.almanac.core.dao.HexagramDao;
import ga.rugal.almanac.core.service.HexagramService;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HexagramServiceImpl implements HexagramService {

  @Autowired
  @Getter
  @Setter
  private HexagramDao dao;
}
