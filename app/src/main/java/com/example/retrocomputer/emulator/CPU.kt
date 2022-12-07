package com.example.retrocomputer.emulator

class CPU() {
    private val bus = Bus()

    //    Registers
    var A: UByte = 0x00U      // Accumulator
    var X: UByte = 0x00U      // Register X
    var Y: UByte = 0x00U      // Register Y
    var SP: UByte = 0x00U  // Stack pointer
    var PC: UShort = 0x0000U // Program counter
    var status: UByte = 0x00U // Status register (current flag)

    //    Flags
    var flagC : Boolean = false  // Carry Bit
    var flagZ : Boolean = false  // Zero
    var flagI : Boolean = false  // Disable Interrupts
    var flagD : Boolean = false  // DecimalMode
    var flagB : Boolean = false  // Break
    var flagU : Boolean = true   // Unused
    var flagV : Boolean = false  // Overflow
    var flagN : Boolean = false  // Negative

    var flagShiftC = (1 shl 0)
    var flagShiftZ = (1 shl 1)
    var flagShiftI = (1 shl 2)
    var flagShiftD = (1 shl 3)
    var flagShiftB = (1 shl 4)
    var flagShiftU = (1 shl 5)
    var flagShiftV = (1 shl 6)
    var flagShiftN = (1 shl 7)

//    Functions / Other Pins

    private fun clock() {

    }
    private fun reset() {

    }
    private fun irq() {     // Interrupt Request

    }
    private fun nmi() {     // Non-Maskable Interrupt

    }

    private fun fetch () : UByte {
        return 0U
    }

    var fetched : UByte = 0x00U

    var addr_abs : UShort = 0x0000U
    var addr_rel : UShort = 0x00U
    var opcode : UByte = 0x00U
    var cycles : UByte = 0U

//    Addressing modes

    enum class AddressingMode {
        IMM, // Immediate
        IMP, // Implied
        ZP0, // Zero Page absolute
        ZPX, // Zero Page X
        ZPY, // Zero Page Y
        REL,  // Relative
        ABS, // Absolute A
        ABX, // Absolute X
        ABY, // Absolute Y
        IND, // Indirect
        IZX, // Pre-indexed indirect
        IZY, // Post-indexed indirect
    }

    private fun handleAddressingMode(addrMode: AddressingMode): UByte {
        return when(addrMode) {
            AddressingMode.IMM -> IMM()
            AddressingMode.IMP -> IMP()
            AddressingMode.ZP0 -> ZP0()
            AddressingMode.ZPX -> ZPX()
            AddressingMode.ZPY -> ZPY()
            AddressingMode.REL -> REL()
            AddressingMode.ABS -> ABS()
            AddressingMode.ABX -> ABX()
            AddressingMode.ABY -> ABY()
            AddressingMode.IND -> IND()
            AddressingMode.IZX -> IZX()
            AddressingMode.IZY -> IZY()
        }
    }

    private fun IMM() : UByte {
        return 0U
    }
    private fun IMP() : UByte {
        return 0U
    }
    private fun ZP0() : UByte {
        return 0U
    }
    private fun ZPX() : UByte {
        return 0U
    }
    private fun ZPY() : UByte {
        return 0U
    }
    private fun REL() : UByte {
        return 0U
    }
    private fun ABS() : UByte {
        return 0U
    }
    private fun ABX() : UByte {
        return 0U
    }
    private fun ABY() : UByte {
        return 0U
    }
    private fun IND() : UByte {
        return 0U
    }
    private fun IZX() : UByte {
        return 0U
    }
    private fun IZY() : UByte {
        return 0U
    }

//    Opcodes

    enum class Opcode {
        ADC, AND, ASL, BIT, BPL, BMI, BVC, BVS, BCC, BCS, BNE, BEQ, BRK, CMP,
        CPX, CPY, DEC, EOR, CLC, SEC, CLI, SEI, CLV, CLD, SED, INC, JMP, JSR,
        LDA, LDX, LDY, LSR, NOP, ORA, TAX, TXA, DEX, INX, TAY, TYA, DEY, INY,
        ROR, ROL, RTI, RTS, SBC, STA, TXS, TSX, PHA, PLA, PHP, PLP, STX, STY,
        XXX
    }

    private fun handleOpcodes(opcode: Opcode): UByte {
        return when(opcode) {
            Opcode.XXX -> XXX()
            Opcode.ADC -> ADC()
            Opcode.AND -> AND()
            Opcode.ASL -> ASL()
            Opcode.BIT -> BIT()
            Opcode.BPL -> BPL()
            Opcode.BMI -> BMI()
            Opcode.BVC -> BVC()
            Opcode.BVS -> BVS()
            Opcode.BCC -> BCC()
            Opcode.BCS -> BCS()
            Opcode.BNE -> BNE()
            Opcode.BEQ -> BEQ()
            Opcode.BRK -> BRK()
            Opcode.CMP -> CMP()
            Opcode.CPX -> CPX()
            Opcode.CPY -> CPY()
            Opcode.DEC -> DEC()
            Opcode.EOR -> EOR()
            Opcode.CLC -> CLC()
            Opcode.SEC -> SEC()
            Opcode.CLI -> CLI()
            Opcode.SEI -> SEI()
            Opcode.CLV -> CLV()
            Opcode.CLD -> CLD()
            Opcode.SED -> SED()
            Opcode.INC -> INC()
            Opcode.JMP -> JMP()
            Opcode.JSR -> JSR()
            Opcode.LDA -> LDA()
            Opcode.LDX -> LDX()
            Opcode.LDY -> LDY()
            Opcode.LSR -> LSR()
            Opcode.NOP -> NOP()
            Opcode.ORA -> ORA()
            Opcode.TAX -> TAX()
            Opcode.TXA -> TXA()
            Opcode.DEX -> DEX()
            Opcode.INX -> INX()
            Opcode.TAY -> TAY()
            Opcode.TYA -> TYA()
            Opcode.DEY -> DEY()
            Opcode.INY -> INY()
            Opcode.ROR -> ROR()
            Opcode.ROL -> ROL()
            Opcode.RTI -> RTI()
            Opcode.RTS -> RTS()
            Opcode.SBC -> SBC()
            Opcode.STA -> STA()
            Opcode.TXS -> TXS()
            Opcode.TSX -> TSX()
            Opcode.PHA -> PHA()
            Opcode.PLA -> PLA()
            Opcode.PHP -> PHP()
            Opcode.PLP -> PLP()
            Opcode.STX -> STX()
            Opcode.STY -> STY()
        }
    }

    private fun XXX() : UByte {
        return 0U
    }
    private fun ADC() : UByte {
        return 0U
    }
    private fun AND() : UByte {
        return 0U
    }
    private fun ASL() : UByte {
        return 0U
    }
    private fun BIT() : UByte {
        return 0U
    }
    private fun BPL() : UByte {
        return 0U
    }
    private fun BMI() : UByte {
        return 0U
    }
    private fun BVC() : UByte {
        return 0U
    }
    private fun BVS() : UByte {
        return 0U
    }
    private fun BCC() : UByte {
        return 0U
    }
    private fun BCS() : UByte {
        return 0U
    }
    private fun BNE() : UByte {
        return 0U
    }
    private fun BEQ() : UByte {
        return 0U
    }
    private fun BRK() : UByte {
        return 0U
    }
    private fun CMP() : UByte {
        return 0U
    }
    private fun CPX() : UByte {
        return 0U
    }
    private fun CPY() : UByte {
        return 0U
    }
    private fun DEC() : UByte {
        return 0U
    }
    private fun EOR() : UByte {
        return 0U
    }
    private fun CLC() : UByte {
        return 0U
    }
    private fun SEC() : UByte {
        return 0U
    }
    private fun CLI() : UByte {
        return 0U
    }
    private fun SEI() : UByte {
        return 0U
    }
    private fun CLV() : UByte {
        return 0U
    }
    private fun CLD() : UByte {
        return 0U
    }
    private fun SED() : UByte {
        return 0U
    }
    private fun INC() : UByte {
        return 0U
    }
    private fun JMP() : UByte {
        return 0U
    }
    private fun JSR() : UByte {
        return 0U
    }
    private fun LDA() : UByte {
        return 0U
    }
    private fun LDX() : UByte {
        return 0U
    }
    private fun LDY() : UByte {
        return 0U
    }
    private fun LSR() : UByte {
        return 0U
    }
    private fun NOP() : UByte {
        return 0U
    }
    private fun ORA() : UByte {
        return 0U
    }
    private fun TAX() : UByte {
        return 0U
    }
    private fun TXA() : UByte {
        return 0U
    }
    private fun DEX() : UByte {
        return 0U
    }
    private fun INX() : UByte {
        return 0U
    }
    private fun TAY() : UByte {
        return 0U
    }
    private fun TYA() : UByte {
        return 0U
    }
    private fun DEY() : UByte {
        return 0U
    }
    private fun INY() : UByte {
        return 0U
    }
    private fun ROR() : UByte {
        return 0U
    }
    private fun ROL() : UByte {
        return 0U
    }
    private fun RTI() : UByte {
        return 0U
    }
    private fun RTS() : UByte {
        return 0U
    }
    private fun SBC() : UByte {
        return 0U
    }
    private fun STA() : UByte {
        return 0U
    }
    private fun TXS() : UByte {
        return 0U
    }
    private fun TSX() : UByte {
        return 0U
    }
    private fun PHA() : UByte {
        return 0U
    }
    private fun PLA() : UByte {
        return 0U
    }
    private fun PHP() : UByte {
        return 0U
    }
    private fun PLP() : UByte {
        return 0U
    }
    private fun STX() : UByte {
        return 0U
    }
    private fun STY() : UByte {
        return 0U
    }

    data class Instruction (
        val name: String,
        val opcode: Opcode,
        val mode: AddressingMode,
        val cycles: UByte,
    )

    var lookup = MutableList<Instruction>(0x100) {
        Instruction("???", Opcode.XXX, AddressingMode.IMP, 2U)
    }

    init {
//        ADC
        lookup[0x69] = Instruction("ADC",Opcode.ADC,AddressingMode.IMM,2U);
        lookup[0x65] = Instruction("ADC",Opcode.ADC,AddressingMode.ZP0,3U);
        lookup[0x75] = Instruction("ADC",Opcode.ADC,AddressingMode.ZPX,4U);
        lookup[0x6D] = Instruction("ADC",Opcode.ADC,AddressingMode.ABS,4U);
        lookup[0x7D] = Instruction("ADC",Opcode.ADC,AddressingMode.ABX,4U);
        lookup[0x79] = Instruction("ADC",Opcode.ADC,AddressingMode.ABY,4U);
        lookup[0x61] = Instruction("ADC",Opcode.ADC,AddressingMode.IZX,6U);
        lookup[0x71] = Instruction("ADC",Opcode.ADC,AddressingMode.IZY,5U);

//        AND
        lookup[0x29] = Instruction("AND",Opcode.AND,AddressingMode.IMM,2U);
        lookup[0x25] = Instruction("AND",Opcode.AND,AddressingMode.ZP0,3U);
        lookup[0x35] = Instruction("AND",Opcode.AND,AddressingMode.ZPX,4U);
        lookup[0x2D] = Instruction("AND",Opcode.AND,AddressingMode.ABS,4U);
        lookup[0x3D] = Instruction("AND",Opcode.AND,AddressingMode.ABX,4U);
        lookup[0x39] = Instruction("AND",Opcode.AND,AddressingMode.ABY,4U);
        lookup[0x21] = Instruction("AND",Opcode.AND,AddressingMode.IZX,6U);
        lookup[0x31] = Instruction("AND",Opcode.AND,AddressingMode.IZY,5U);

//        ASL
        lookup[0x0A] = Instruction("ASL",Opcode.ASL,AddressingMode.IMP,2U);
        lookup[0x06] = Instruction("ASL",Opcode.ASL,AddressingMode.ZP0,5U);
        lookup[0x16] = Instruction("ASL",Opcode.ASL,AddressingMode.ZPX,6U);
        lookup[0x0E] = Instruction("ASL",Opcode.ASL,AddressingMode.ABS,6U);
        lookup[0x1E] = Instruction("ASL",Opcode.ASL,AddressingMode.ABX,7U);

//        BCC
        lookup[0x90] = Instruction("BCC",Opcode.BCC,AddressingMode.REL,2U);

//        BCS
        lookup[0xB0] = Instruction("BCS",Opcode.BCS,AddressingMode.REL,2U);

//        BEQ
        lookup[0xF0] = Instruction("BEQ",Opcode.BEQ,AddressingMode.REL,2U);

//        BIT
        lookup[0x24] = Instruction("BIT",Opcode.BIT,AddressingMode.ZP0,3U);
        lookup[0x2C] = Instruction("BIT",Opcode.BIT,AddressingMode.ABS,4U);

//        BMI
        lookup[0x30] = Instruction("BMI",Opcode.BMI,AddressingMode.REL,2U);

//        BNE
        lookup[0xD0] = Instruction("BNE",Opcode.BNE,AddressingMode.REL,2U);

//        BPL
        lookup[0x10] = Instruction("BPL",Opcode.BPL,AddressingMode.REL,2U);

//        BRK
        lookup[0x00] = Instruction("BRK",Opcode.BRK,AddressingMode.IMP,7U);

//        BVC
        lookup[0x50] = Instruction("BVC",Opcode.BVC,AddressingMode.REL,2U);

//        BVS
        lookup[0x70] = Instruction("BVS",Opcode.BVS,AddressingMode.REL,2U);

//        CLC
        lookup[0x18] = Instruction("CLC",Opcode.CLC,AddressingMode.IMP,2U);

//        CLD
        lookup[0xD8] = Instruction("CLD",Opcode.CLC,AddressingMode.IMP,2U);

//        CLI
        lookup[0x58] = Instruction("CLI",Opcode.CLI,AddressingMode.IMP,2U);

//        CLV
        lookup[0xB8] = Instruction("CLV",Opcode.CLV,AddressingMode.IMP,2U);

//        CMP
        lookup[0xC9] = Instruction("CMP",Opcode.CMP,AddressingMode.IMM,2U);
        lookup[0xC5] = Instruction("CMP",Opcode.CMP,AddressingMode.ZP0,3U);
        lookup[0xD5] = Instruction("CMP",Opcode.CMP,AddressingMode.ZPX,4U);
        lookup[0xCD] = Instruction("CMP",Opcode.CMP,AddressingMode.ABS,4U);
        lookup[0xDD] = Instruction("CMP",Opcode.CMP,AddressingMode.ABX,4U);
        lookup[0xD9] = Instruction("CMP",Opcode.CMP,AddressingMode.ABY,4U);
        lookup[0xC1] = Instruction("CMP",Opcode.CMP,AddressingMode.IZX,6U);
        lookup[0xD1] = Instruction("CMP",Opcode.CMP,AddressingMode.IZY,5U);

//        CPX
        lookup[0xE0] = Instruction("CPX",Opcode.CPX,AddressingMode.IMM,2U);
        lookup[0xE4] = Instruction("CPX",Opcode.CPX,AddressingMode.ZP0,3U);
        lookup[0xEC] = Instruction("CPX",Opcode.CPX,AddressingMode.ABS,4U);

//        CPY
        lookup[0xC0] = Instruction("CPY",Opcode.CPY,AddressingMode.IMM,2U);
        lookup[0xC4] = Instruction("CPY",Opcode.CPY,AddressingMode.ZP0,3U);
        lookup[0xCC] = Instruction("CPY",Opcode.CPY,AddressingMode.ABS,4U);

//        DEC
        lookup[0xC6] = Instruction("DEC",Opcode.DEC,AddressingMode.ZP0,5U);
        lookup[0xD6] = Instruction("DEC",Opcode.DEC,AddressingMode.ZPX,6U);
        lookup[0xCE] = Instruction("DEC",Opcode.DEC,AddressingMode.ABS,6U);
        lookup[0xDE] = Instruction("DEC",Opcode.DEC,AddressingMode.ABX,7U);

//        DEX
        lookup[0xCA] = Instruction("DEX",Opcode.DEX,AddressingMode.IMP,2U);

//        DEY
        lookup[0x88] = Instruction("DEY",Opcode.DEY,AddressingMode.IMP,2U);

//        EOR
        lookup[0x49] = Instruction("EOR",Opcode.EOR,AddressingMode.IMM,2U);
        lookup[0x45] = Instruction("EOR",Opcode.EOR,AddressingMode.ZP0,3U);
        lookup[0x55] = Instruction("EOR",Opcode.EOR,AddressingMode.ZPX,4U);
        lookup[0x4D] = Instruction("EOR",Opcode.EOR,AddressingMode.ABS,4U);
        lookup[0x5D] = Instruction("EOR",Opcode.EOR,AddressingMode.ABX,4U);
        lookup[0x59] = Instruction("EOR",Opcode.EOR,AddressingMode.ABY,4U);
        lookup[0x41] = Instruction("EOR",Opcode.EOR,AddressingMode.IZX,6U);
        lookup[0x51] = Instruction("EOR",Opcode.EOR,AddressingMode.IZY,5U);

//        INC
        lookup[0xE6] = Instruction("INC",Opcode.INC,AddressingMode.ZP0,5U);
        lookup[0xF6] = Instruction("INC",Opcode.INC,AddressingMode.ZPX,6U);
        lookup[0xEE] = Instruction("INC",Opcode.INC,AddressingMode.ABS,6U);
        lookup[0xFE] = Instruction("INC",Opcode.INC,AddressingMode.ABX,7U);

//        INX
        lookup[0xE8] = Instruction("INX",Opcode.INX,AddressingMode.IMP,2U);

//        INY
        lookup[0xC8] = Instruction("INY",Opcode.INY,AddressingMode.IMP,2U);

//        JMP
        lookup[0x4C] = Instruction("JMP",Opcode.JMP,AddressingMode.ABS,3U);
        lookup[0x6C] = Instruction("JMP",Opcode.JMP,AddressingMode.IND,5U);

//        JSR
        lookup[0x20] = Instruction("JSR",Opcode.JSR,AddressingMode.ABS,6U);

//        LDA
        lookup[0xA9] = Instruction("LDA",Opcode.LDA,AddressingMode.IMM,2U);
        lookup[0xA5] = Instruction("LDA",Opcode.LDA,AddressingMode.ZP0,3U);
        lookup[0xB5] = Instruction("LDA",Opcode.LDA,AddressingMode.ZPX,4U);
        lookup[0xAD] = Instruction("LDA",Opcode.LDA,AddressingMode.ABS,4U);
        lookup[0xBD] = Instruction("LDA",Opcode.LDA,AddressingMode.ABX,4U);
        lookup[0xB9] = Instruction("LDA",Opcode.LDA,AddressingMode.ABY,4U);
        lookup[0xA1] = Instruction("LDA",Opcode.LDA,AddressingMode.IZX,6U);
        lookup[0xB1] = Instruction("LDA",Opcode.LDA,AddressingMode.IZY,5U);

//        LDX
        lookup[0xA2] = Instruction("LDX",Opcode.LDX,AddressingMode.IMM,2U);
        lookup[0xA6] = Instruction("LDX",Opcode.LDX,AddressingMode.ZP0,3U);
        lookup[0xB6] = Instruction("LDX",Opcode.LDX,AddressingMode.ZPY,4U);
        lookup[0xAE] = Instruction("LDX",Opcode.LDX,AddressingMode.ABS,4U);
        lookup[0xBE] = Instruction("LDX",Opcode.LDX,AddressingMode.ABY,4U);

//        LDY
        lookup[0xA0] = Instruction("LDY",Opcode.LDY,AddressingMode.IMM,2U);
        lookup[0xA4] = Instruction("LDY",Opcode.LDY,AddressingMode.ZP0,3U);
        lookup[0xB4] = Instruction("LDY",Opcode.LDY,AddressingMode.ZPX,4U);
        lookup[0xAC] = Instruction("LDY",Opcode.LDY,AddressingMode.ABS,4U);
        lookup[0xBC] = Instruction("LDY",Opcode.LDY,AddressingMode.ABX,4U);

//        LSR
        lookup[0x4A] = Instruction("LSR",Opcode.LSR,AddressingMode.IMP,2U);
        lookup[0x46] = Instruction("LSR",Opcode.LSR,AddressingMode.ZP0,5U);
        lookup[0x56] = Instruction("LSR",Opcode.LSR,AddressingMode.ZPX,6U);
        lookup[0x4E] = Instruction("LSR",Opcode.LSR,AddressingMode.ABS,6U);
        lookup[0x5E] = Instruction("LSR",Opcode.LSR,AddressingMode.ABX,7U);

//        NOP
        lookup[0xEA] = Instruction("???",Opcode.NOP,AddressingMode.IMP,2U);

//        ORA
        lookup[0x09] = Instruction("ORA",Opcode.ORA,AddressingMode.IMM,2U);
        lookup[0x05] = Instruction("ORA",Opcode.ORA,AddressingMode.ZP0,3U);
        lookup[0x15] = Instruction("ORA",Opcode.ORA,AddressingMode.ZPX,4U);
        lookup[0x0D] = Instruction("ORA",Opcode.ORA,AddressingMode.ABS,4U);
        lookup[0x1D] = Instruction("ORA",Opcode.ORA,AddressingMode.ABX,4U);
        lookup[0x19] = Instruction("ORA",Opcode.ORA,AddressingMode.ABY,4U);
        lookup[0x01] = Instruction("ORA",Opcode.ORA,AddressingMode.IZX,6U);
        lookup[0x11] = Instruction("ORA",Opcode.ORA,AddressingMode.IZY,5U);

//        PHA
        lookup[0x48] = Instruction("PHA",Opcode.PHA,AddressingMode.IMP,3U);

//        PHP
        lookup[0x08] = Instruction("PHP",Opcode.PHP,AddressingMode.IMP,3U);

//        PLA
        lookup[0x68] = Instruction("PLA",Opcode.PLA,AddressingMode.IMP,4U);

//        PLP
        lookup[0x28] = Instruction("PLP",Opcode.PLP,AddressingMode.IMP,4U);

//        ROL
        lookup[0x2A] = Instruction("ROL",Opcode.ROL,AddressingMode.IMP,2U);
        lookup[0x26] = Instruction("ROL",Opcode.ROL,AddressingMode.ZP0,5U);
        lookup[0x36] = Instruction("ROL",Opcode.ROL,AddressingMode.ZPX,6U);
        lookup[0x2E] = Instruction("ROL",Opcode.ROL,AddressingMode.ABS,6U);
        lookup[0x3E] = Instruction("ROL",Opcode.ROL,AddressingMode.ABX,7U);

//        ROR
        lookup[0x6A] = Instruction("ROR",Opcode.ROR,AddressingMode.IMP,2U);
        lookup[0x66] = Instruction("ROR",Opcode.ROR,AddressingMode.ZP0,5U);
        lookup[0x76] = Instruction("ROR",Opcode.ROR,AddressingMode.ZPX,6U);
        lookup[0x6E] = Instruction("ROR",Opcode.ROR,AddressingMode.ABS,6U);
        lookup[0x7E] = Instruction("ROR",Opcode.ROR,AddressingMode.ABX,7U);

//        RTI
        lookup[0x40] = Instruction("RTI",Opcode.RTI,AddressingMode.IMP,6U);

//        RTS
        lookup[0x60] = Instruction("RTS",Opcode.RTS,AddressingMode.IMP,6U);

//        SBC
        lookup[0xE9] = Instruction("SBC",Opcode.SBC,AddressingMode.IMM,2U);
        lookup[0xE5] = Instruction("SBC",Opcode.SBC,AddressingMode.ZP0,3U);
        lookup[0xED] = Instruction("SBC",Opcode.SBC,AddressingMode.ZPX,4U);
        lookup[0xFD] = Instruction("SBC",Opcode.SBC,AddressingMode.ABS,4U);
        lookup[0xF5] = Instruction("SBC",Opcode.SBC,AddressingMode.ABX,4U);
        lookup[0xF9] = Instruction("SBC",Opcode.SBC,AddressingMode.ABY,4U);
        lookup[0xE1] = Instruction("SBC",Opcode.SBC,AddressingMode.IZX,6U);
        lookup[0xF1] = Instruction("SBC",Opcode.SBC,AddressingMode.IZY,5U);

//        SEC
        lookup[0x38] = Instruction("SEC",Opcode.SEC,AddressingMode.IMP,2U);

//        SED
        lookup[0xF8] = Instruction("SED",Opcode.SED,AddressingMode.IMP,2U);

//        SEI
        lookup[0x78] = Instruction("SEI",Opcode.SEI,AddressingMode.IMP,2U);

//        STA
        lookup[0x85] = Instruction("STA",Opcode.STA,AddressingMode.ZP0,3U);
        lookup[0x95] = Instruction("STA",Opcode.STA,AddressingMode.ZPX,4U);
        lookup[0x8D] = Instruction("STA",Opcode.STA,AddressingMode.ABS,4U);
        lookup[0x9D] = Instruction("STA",Opcode.STA,AddressingMode.ABX,5U);
        lookup[0x99] = Instruction("STA",Opcode.STA,AddressingMode.ABY,5U);
        lookup[0x81] = Instruction("STA",Opcode.STA,AddressingMode.IZX,6U);
        lookup[0x91] = Instruction("STA",Opcode.STA,AddressingMode.IZY,6U);

//        STX
        lookup[0x86] = Instruction("STX",Opcode.STX,AddressingMode.ZP0,3U);
        lookup[0x96] = Instruction("STX",Opcode.STX,AddressingMode.ZPY,4U);
        lookup[0x8E] = Instruction("STX",Opcode.STX,AddressingMode.ABS,4U);

//        STY
        lookup[0x84] = Instruction("STY",Opcode.STY,AddressingMode.ZP0,3U);
        lookup[0x94] = Instruction("STY",Opcode.STY,AddressingMode.ZPX,4U);
        lookup[0x8C] = Instruction("STY",Opcode.STY,AddressingMode.ABS,4U);

//        TAX
        lookup[0xAA] = Instruction("TAX",Opcode.TAX,AddressingMode.IMP,2U);

//        TAY
        lookup[0xA8] = Instruction("TAY",Opcode.TAY,AddressingMode.IMP,2U);

//        TSX
        lookup[0xBA] = Instruction("TSX",Opcode.TSX,AddressingMode.IMP,2U);

//        TXA
        lookup[0x8A] = Instruction("TXA",Opcode.TXA,AddressingMode.IMP,2U);

//        TXS
        lookup[0x9A] = Instruction("TXS",Opcode.TXS,AddressingMode.IMP,2U);

//        TYA
        lookup[0x98] = Instruction("TYA",Opcode.TYA,AddressingMode.IMP,2U);
    }
}
