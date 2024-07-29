package webtestframework.dto;

import java.util.List;

public record ShippingDetailsDTO(String email, String firstName, String lastName, String company, String streetAddress,
                                 String city, String state, String postalCode, String country, String phoneNumber) {

    public static ShippingDetailsDTO fromTableRow(List<String> tableRow) {
        return new ShippingDetailsDTO(tableRow.getFirst(), tableRow.get(1), tableRow.get(2), tableRow.get(3),tableRow.get(4),
                               tableRow.get(5), tableRow.get(6), tableRow.get(7), tableRow.get(8), tableRow.get(9));
    }
}
