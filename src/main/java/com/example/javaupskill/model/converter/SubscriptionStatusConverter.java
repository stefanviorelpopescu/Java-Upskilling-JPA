package com.example.javaupskill.model.converter;

import com.example.javaupskill.model.SubscriptionStatus;

import javax.persistence.AttributeConverter;

public class SubscriptionStatusConverter implements AttributeConverter<SubscriptionStatus, String>
{
    @Override
    public String convertToDatabaseColumn(SubscriptionStatus attribute)
    {
        if (attribute == null) {
            return null;
        }
        String toSave = "";
        if (attribute.getSubscribedToDailyNewsletter()) {
            toSave += "Y";
        } else {
            toSave += "N";
        }
        if (attribute.getSubscribedToWeeklyDigest()) {
            toSave += "Y";
        } else {
            toSave += "N";
        }
        if (attribute.getSubscribedToPromotionalOffers()) {
            toSave += "Y";
        } else {
            toSave += "N";
        }
        return toSave;
    }

    @Override
    public SubscriptionStatus convertToEntityAttribute(String dbData)
    {
        SubscriptionStatus toReturn = new SubscriptionStatus();
        String[] split = dbData.split("");
        toReturn.setSubscribedToDailyNewsletter(split[0].equals("Y"));
        toReturn.setSubscribedToWeeklyDigest(split[1].equals("Y"));
        toReturn.setSubscribedToPromotionalOffers(split[2].equals("Y"));

        return toReturn;
    }
}
