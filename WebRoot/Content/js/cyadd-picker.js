
/* global $:true */
/* jshint unused:false*/

+ function ($) {
    "use strict";
    var defaults;
    var rawParent = [],rawChild = [],provincesName=[],provincesCode=[];
    var sub = function (pcode) {
        var result = [];
        $.each(rawChild, function (index, item) {
            if (item.code.replace("VD", "DD").indexOf(pcode) > -1) {
                result.push(item);
            }
        });
        if (result.length) return result;
        return [];
    };

    var getCities = function (d) {
        for (var i = 0; i < provincesName.length; i++) {
            if (provincesName[i] === d) return sub(provincesCode[i]);
        }
        return [];
    };
    var parseInitValue = function (val) {
        var p = provincesCode[0], c;
        var tokens = val.split(' ');
        for (var i = 0; i < provincesName.length; i++) {
            if (provincesName[i] === tokens[0]) {
                p = provincesCode[i];
            }
        }       
        sub(p).map(function (t) {
            if (t.fullname === tokens[1]) c = t.code;
        });
        return [p, c];
    }

    $.fn.cyaddPicker = function (params) {
        params = $.extend({}, defaults, params);
        return this.each(function () {
            var self = this;            
            rawParent =$.projectNameItems;
            rawChild = $.damItems;
            $.each(rawParent, function (index, item) {
                provincesName.push(item.fullname);
                provincesCode.push(item.code);
            });
            var initCities = sub(provincesCode[0]);            
            var initCitiesName = initCities.map(function (c) {
                return c.fullname;
            });
            var initCitiesCode = initCities.map(function (c) {
                return c.code;
            });

            var currentProvince = provincesName[0];
            var currentCity = initCitiesName[0];

            var cols = [
                {
                    displayValues: provincesName,
                    values: provincesCode,
                    cssClass: "col-province"
                },
                {
                    displayValues: initCitiesName,
                    values: initCitiesCode,
                    cssClass: "col-city"
                }
            ];
            var config = {

                cssClass: "city-picker",
                rotateEffect: false,  //为了性能
                formatValue: function (p, values, displayValues) {
                    return displayValues.join(' ');
                },
                onChange: function (picker, values, displayValues) {
                    var newProvince = picker.cols[0].displayValue;
                    var newCity;
                    if (newProvince !== currentProvince) {
                        var newCities = getCities(newProvince);
                        newCity = newCities[0].fullname;
                        picker.cols[1].replaceValues(newCities.map(function (c) {
                            return c.code;
                        }), newCities.map(function (c) {
                            return c.fullname;
                        }));
                        currentProvince = newProvince;
                        currentCity = newCity;
                        picker.updateValue();
                        return false; // 因为数据未更新完，所以这里不进行后序的值的处理
                    }
                    //如果最后一列是空的，那么取倒数第二列
                    var len = (values[values.length - 1] ? values.length - 1 : values.length - 2)
                    $(self).attr('data-code', values[len]);
                    $(self).attr('data-codes', values.join(','));
                    if (params.onChange) {
                        params.onChange.call(self, picker, values, displayValues);
                    }
                },
                cols: cols
            };
            if (!this) return;
            var p = $.extend({}, params, config);
            //计算value
            var val = $(this).val();
            if (!val) val = '贯孟堤 贯孟堤长垣段10+000';
            currentProvince = val.split(" ")[0];
            currentCity = val.split(" ")[1];
            if (val) {
                p.value = parseInitValue(val);
                if (p.value[0]) {
                    var cities = sub(p.value[0]);
                    p.cols[1].values = cities.map(function (c) {
                        return c.code;
                    });
                    p.cols[1].displayValues = cities.map(function (c) {
                        return c.fullname;
                    });
                }
            }
            $(this).picker(p);
        });
    };
}($);
