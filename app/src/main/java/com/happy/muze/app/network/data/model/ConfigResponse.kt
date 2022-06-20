package com.happy.muze.app.network.data.model


import com.google.gson.annotations.SerializedName

data class ConfigResponse(
    @SerializedName("configs")
    var configs: Configs?,
    @SerializedName("plugins")
    var plugins: Plugins?,
    @SerializedName("result")
    var result: String?
) {
    data class Configs(
        @SerializedName("hide_cto")
        var hideCto: String?,
        @SerializedName("mobile_fingerscan")
        var mobileFingerscan: String?,
        @SerializedName("mobile_fingerscan_advance")
        var mobileFingerscanAdvance: String?,
        @SerializedName("s3upload")
        var s3upload: String?,
        @SerializedName("secure_checkin")
        var secureCheckin: String?
    )

    data class Plugins(
        @SerializedName("ADVANCECALCULATION")
        var aDVANCECALCULATION: String?,
        @SerializedName("APPROVALCENTER")
        var aPPROVALCENTER: String?,
        @SerializedName("AWARDWARNING")
        var aWARDWARNING: String?,
        @SerializedName("BENEFIT")
        var bENEFIT: String?,
        @SerializedName("CHECKINREQUEST")
        var cHECKINREQUEST: String?,
        @SerializedName("DELIGENTALLOWANCE")
        var dELIGENTALLOWANCE: String?,
        @SerializedName("DEPENDENT")
        var dEPENDENT: String?,
        @SerializedName("DOCUMENT")
        var dOCUMENT: String?,
        @SerializedName("EXPENSEREQUEST")
        var eXPENSEREQUEST: String?,
        @SerializedName("EZYHRPROJECT")
        var eZYHRPROJECT: String?,
        @SerializedName("IMPLEMENT")
        var iMPLEMENT: String?,
        @SerializedName("INTERFACE")
        var iNTERFACE: String?,
        @SerializedName("LATEREQUEST")
        var lATEREQUEST: String?,
        @SerializedName("MULTILANG")
        var mULTILANG: String?,
        @SerializedName("NOPAYROLL")
        var nOPAYROLL: String?,
        @SerializedName("ONBOARDING")
        var oNBOARDING: String?,
        @SerializedName("PAYROLLCOMPARISON")
        var pAYROLLCOMPARISON: String?,
        @SerializedName("PCCHECKIN")
        var pCCHECKIN: String?,
        @SerializedName("RECRUITMENT")
        var rECRUITMENT: String?,
        @SerializedName("SHIFTREQUEST")
        var sHIFTREQUEST: String?,
        @SerializedName("SHIFTSWAPREQUEST")
        var sHIFTSWAPREQUEST: String?,
        @SerializedName("SURVEY")
        var sURVEY: String?,
        @SerializedName("TRAININGRECORD")
        var tRAININGRECORD: String?,
        @SerializedName("TRAVEL")
        var tRAVEL: String?,
        @SerializedName("WORKOUTSIDE")
        var wORKOUTSIDE: String?
    )
}
