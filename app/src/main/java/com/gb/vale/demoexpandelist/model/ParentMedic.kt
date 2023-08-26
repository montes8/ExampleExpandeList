package com.gb.vale.demoexpandelist.model

class ParentMedic(
    var nameClinic: String,
    var address: String,
    var listHistory: List<ExpandeHistory>
) {
    var isSelected = false

}