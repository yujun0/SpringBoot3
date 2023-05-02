package com.example.webmvcconfig.formatter;

import com.example.webmvcconfig.model.DeviceInfo;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Locale;
import java.util.StringJoiner;

public class DeviceFormatter implements Formatter<DeviceInfo> {
    @Override
    public DeviceInfo parse(String text, Locale locale) throws ParseException {
        DeviceInfo info = null;
        if (StringUtils.hasLength(text)) {
            String[] items = text.split(";");
            info = new DeviceInfo();
            info.setItem1(items[0]);
            info.setItem2(items[1]);
            info.setItem3(items[2]);
            info.setItem4(items[3]);
            info.setItem5(items[4]);
        }
        return info;
    }

    // 將 DeviceInfo 轉為 String
    @Override
    public String print(DeviceInfo object, Locale locale) {
        StringJoiner joiner = new StringJoiner("#");
        joiner.add(object.getItem1()).add(object.getItem2());

        return joiner.toString();
    }
}
