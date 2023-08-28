package ru.lusty.backend.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordDeviceLocationRequest {
    private Double latitude;
    private Double longitude;
}
