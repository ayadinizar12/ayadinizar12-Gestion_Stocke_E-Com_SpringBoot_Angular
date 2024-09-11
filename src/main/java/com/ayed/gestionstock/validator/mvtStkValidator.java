package com.ayed.gestionstock.validator;

import com.ayed.gestionstock.dto.MvtStkDTO;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class mvtStkValidator {

  public static List<String> validate(MvtStkDTO dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("Veuillez renseigner la date du mouvenent");
      errors.add("Veuillez renseigner la quantite du mouvenent");
      errors.add("Veuillez renseigner l'article");
      errors.add("Veuillez renseigner le type du mouvement");

      return errors;
    }
    if (dto.getDateMvt() == null) {
      errors.add("Veuillez renseigner la date du mouvenent");
    }
    if (dto.getQuantite() == null || dto.getQuantite().compareTo(BigDecimal.ZERO) == 0) {
      errors.add("Veuillez renseigner la quantite du mouvenent");
    }
    if (dto.getArticle() == null || dto.getArticle().getId() == null) {
      errors.add("Veuillez renseigner l'article");
    }
    if (!StringUtils.hasLength(dto.getTypeMvt().name())) {
      errors.add("Veuillez renseigner le type du mouvement");
    }

    return errors;
  }

}
