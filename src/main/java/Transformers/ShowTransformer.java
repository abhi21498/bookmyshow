package Transformers;

import Models.Show;
import RequestDTOs.AddShowRequest;

public class ShowTransformer {
    public static Show convertAddRequestToEntity(AddShowRequest addShowRequest) {

        Show showObj = Show.builder().showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .build();

        return showObj;
    }
}
