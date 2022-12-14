package com.example.retrocomputer

// Struktura zdisassemblowanego kodu
data class Disassembly(
    var address: Int,
    var assembly: String,
    var instruction: Instruction,
    var hex: String
) {
    override fun toString(): String{
        return "$assembly${hex.padEnd(13)}${instruction.mode.name}     ${instruction.cycles}"
    }
}