package com.yopyop.wackend.dto;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yopyop.wackend.model.*;


public class DTOMapper {

    final static Logger logger = LoggerFactory.getLogger("DTOMapper");
    
    public static SubscriptionDTO toSubscriptionDTO(Subscription subscription) {
        SubscriptionDTO subscriptionDto = new SubscriptionDTO();
        subscriptionDto.setId(subscription.getId());
        subscriptionDto.setPrm(subscription.getPrm());

        List<ErlDTO> erlsDto = new ArrayList<>();

        for (Erl erl: subscription.getErls()) {
            ErlDTO erlDto = new ErlDTO();
            erlDto.setId(erl.getId());
            erlDto.setCid(erl.getCid());
            erlDto.setSn(erl.getSn());
            erlsDto.add(erlDto);
        }
        subscriptionDto.setErls(erlsDto);

        return subscriptionDto;
    }

    public static AllowedPairingsDTO toAllowedPairingsDTO(AllowedPairings allowedPairings) {
    	AllowedPairingsDTO allowedPairingsDto = new AllowedPairingsDTO();
    	allowedPairingsDto.setErlCid(allowedPairings.getErlCid());
    	allowedPairingsDto.setSubscriptionId(allowedPairings.getSubscriptionId());

        return allowedPairingsDto;
    }
    
    public static ErlDTO toErlDTO(Erl erl) {
    	ErlDTO erlDto = new ErlDTO();
    	erlDto.setCid(erl.getCid());
    	erlDto.setId(erl.getId());
    	erlDto.setSn(erl.getSn());
        return erlDto;
    }
    
    public static TagDTO toTagDTO(Tag tag) {
    	TagDTO tagDto = new TagDTO();
    	tagDto.setId(tag.getId());
    	tagDto.setName(tag.getName());
    	tagDto.setValidAfter(tag.getValidAfter());
    	
        List<PartDTO> partsDto = new ArrayList<>();

        for (Part part: tag.getParts()) {
            PartDTO partDto = new PartDTO();
            partDto.setId(part.getId());
            partDto.setName(part.getName());
            partDto.setUrl(part.getUrl());
            partsDto.add(partDto);
        }
        tagDto.setParts(partsDto);
        
        return tagDto;
    }
    
}