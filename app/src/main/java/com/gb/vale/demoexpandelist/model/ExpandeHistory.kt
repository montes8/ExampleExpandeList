package com.gb.vale.demoexpandelist.model

class ExpandeHistory(var dateHistory: String, var description: String) {

    override fun toString(): String {
        return "ExpandeHistory{" +
                "dateHistory='" + dateHistory + '\'' +
                ", description='" + description + '\'' +
                '}'
    }
}