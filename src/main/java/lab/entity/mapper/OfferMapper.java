package lab.entity.mapper;

import lab.entity.Offer;
import lab.entity.dto.AddOfferDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    Offer offerDtoToOfferEntity(AddOfferDTO addOfferDTO);
}
