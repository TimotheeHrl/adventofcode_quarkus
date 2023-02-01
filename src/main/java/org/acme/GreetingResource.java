package org.acme;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

import static io.quarkus.arc.ComponentsProvider.LOG;

@Path("/hello")
public class GreetingResource {
//public static String listStr = "BzRmmzZHzVBzgVQmZLPtqqffPqWqJmPLlL hpvvTDcrCjhpcrvcGGhfLHMlLtMCqflNlWPJlJ hGjhncHhGnhbTHczBBZVVSbRwgSgRV rWVQjPQQjGRWNSrWrPjcptwBpqqJBtJBBcZgMdtq zzmmpzfTCFpTlMlJJwBgMlqMBt TvLszpbhhTLmsnRQPDQGWDWRvQSR zGzvLlGlQHLGBQZlhBWhdjRdmdWRcjPj fTJNfTfNSRWPhjdjfj pbsbVVnpSnbVTprnbqqrzvLLgQlGLPLHll ZCCCsWvNvmsCsCmZLZmgMLRpQMhwQRpQRfphfprpTfpM tlncPjzlndctbzcPPBcjwDphwrfGGDffbDRpDTGG cdqnddwzqjNVWVLZZLZq DTLbDbRrlQbwhhNrmmfwdt zzMJMzjCjJJjvLjMPJpcgPpzfhHdfqWcqddwtwfqdttcNtdN pJCzVpCvDZBLsVRQ STzBBbJzRRBZBRTqCCsfZLtNNLClCsfh jsQnnQjjHcvQFrcPwCmtLCNlvDfftfff sGFscMQQMMpqzqbMbd QlNDWGsjQjgQllWQsbtzqTJczTJcbFmmFJJP MhLrhgLVndRmzJFzVqqJqP pSLnMdwhwdRZRSwhLZwLhdGWQjlsgWjNQWWSvgBsWDlj THjSRFSddTjdBTcPLcVVvVBw GzWnWfndWfznDfsnsBsPVwVwPPLL zNflzJWqqzQDdSStHNZNpFFtbj FSzDmsFSFlDlBzqVjqHHjHHpVgHLbp rTrTtTQQntRQnQJQgggHZttVgHLBLhZL WTJJRRQCRRJTRdBCRdvRNDFSWFMPmDlPPSsNPSzS WQldlMtMVQgVMQHnDGbHGGnRnQmD rqcZPrCFjmHlbGjZ zSScchqwchBzTzFzhhSlcCwNtdVWWJgsVdMtWNgNVWTJTd lMZqjMWllrTTspjprWWSSwgWNSVNDmWGVwFwgN cdCCdLHcnndHJnmCRntLBnRzDvFNtNDVzgSgwDgFNVzFVv BRLcCCJCmJdcRhfjPPZphrlrPqlZ GdGqcrrZGDrvDJJqJHcBvmFFgmFMMgMgBtMLTssLmF NbPVPDlljPmTmsTj VfQDhflCCRWdcrQwJvvnJv RLcWgLCqqPQLcqZwzHgwmmrmmtgwTw DhbhNrMpnJSDJwVTHmmTVnTTVj lrsvblMDlcWcfQPQ PVldlphHwGwJJGdjZZWsRbbsGsNWrWQbNbQR SqcDvTmDLtfmSmtqppfqzTgTQBrRQsbCFWbNNFQFBBrRbLNb MgtmTgtfpqVlnVddZMwV BdmfmPBPSbSNdGSdvWrwcZrccZPPcZnH jzzLsjsMRlQQVHwswvvZrCHrrT VqhzVFzplFlpLwpMphLRQQVRmSqgbdGtNJBmNSmgGbtggSgt DHVpNZjdZjFZWVFHpvFvzmlRzPnlfznFRz lrTBTsBwwMbrrwLPPfwGmGzvRf scrtMhMCtJBBBclbHdHttWZWDSqDSjHj wzqsPmqsbsfqBwPMNRMMZcZmFFNtZM CgCnhlvvLJgcRFNNBdCpWM QnQrVgHSvVHjbjTGBbbTHb HdrVrdqFDdZVmHgRmDRFHMnTdTssMGnLnPJLbPTbCs SczlScjwcNzplNzQSSfjwQSrTGGsbTsnTCnGTMCMLMGGbN wQlfjrhfhQFHqZhRZRtD RsfJDGJvzPNcjpddSWJWMd LLCbBCwCrCmVVnrmhQFmbVhdcdlWpjZzSpMdWSpcWczSBj rrLCbTwnHTvzvNGT wPhPhbCqqSCrtJDlqvlrJr RVVZddLFRZZcQLvJJtzptlgPJp TVQRZGVncFdTGWZdCNShHhfPNwwsWPwb dzLVzPSgrgDDDCMSMLLPwFmdTTcsvmwNwjNsHcFF nWBGntQfGNGBflWBBqlpRQGbWFvjwsbsFswbvTHjjbmHTc tBNJBnGBflQnDPJrPhDgrPVg VtWztWtqpqzWpWzqjNRjNpWTmrrmrSbnmJwSJwnMPrCSJVwM sDHsBDhBdsBZGcHvLHDLhhCSnRSwCJMZrPbmnMbJSCSR ccLRhgsLBdRsdHNTFFNNgqTglqzF hztlmDhPhgPlPNNgmZMCbmwwQjcwjjwMjVCd RSJRrRqnqQJFqvnTGrHCcHHCCHHbHHMcMvdM qGJsnQTRsStsftPlhPNl BFFBLPRCwsLwhlPlRmhcGGrbmmGjfNTTnp VJMVpzgqggJnrjmjNcMjmT VqdSZtQgZvtdzqHqHtVZdVQpCDWWFdwlRPDpWPPBCswlWD fCWCsjPzcbzwRSzVTzhhDLqvdg TmJtrNJrBLSLJqgS ptNTQFHrZlnpFPwsWMbRjCpcjR nJmQNCmbmlllmbClbfMLjMFqbGBsdLFq ZcgTWcTnMqqMTBqF tPgctSnPctZZgDWzZgQHwNmHlhlmzlQhlJlw ZpTCwpffdslvgShCBhqhRz FDMPnNFNmBPzvRPRBg nNgMrnnDGjDmJMmnFdZTTsdsrZrslcwcQr pTmczpCldcdDDnPttpvWSqbpJf jgjRZMGHhGLgQrjvPWzPJgJvzStbbq LGNLLNBBzcDFCBwwFC nJTTqnrNvTzNMzzNfqrTPrJnwpwPpZpsHccZVsBRpcVHwpcp bgDhgbghLWmFmStctVpZtBCVCCpfZp LLSgLGSjggFGbSSbmMnrvqvzjfzTNrJrqM RRpDmmPMTjwfGmJQgQ WsNscdnvvdVZFVnnrZbjjflwljlbzfGFjQjq NnLZsNnrrVVVcvdBLTPCPCRMwhPMBMPhCt lbVvzngGJnVbJHpHtHNPpdSQvc TsMBswFZsWMWBZMNwPtNNtRNHcNpSQ CcZCTrZDsjZTsTsshWhrWrTnfgbLDfJzVVLVVlgfnzfVGV JzTTRtJRZWmWjrMHCT DDFGlLGcGlSSSLsFGBspPBmNMBHMghmWNmWjWCmWtH nSSpnbsGlLDnpPsSSspFtVvffRQdVzqvvbqdfVQwRz sMhzszlHHDsWbthHDqsbJjpLNtmjVJmVLLVLVLBp nrTPrGwfPLdprzJzdL wgPQcTGGzgccwCgnRwgRChFhlWSDqWWQMWhssSsMQl NSNmwtpSpCpvMphCsr PHcRGPLJMrsvzsqG QHjbnRMcfbPbQZmlZgZlgBBQ cPRPbhQjbQRdtPQdLqLHqzFZjCFCqLjC mmfsnnwrfvwrfSNZFzHHLDCFNlLlqDlN wsmrwswwGTffMrBnmQttJtcMZQQtPJPbZc MvBPDDRRdnnvHPCHZLHZsFLL rmJcbVqbcjWwWjQHLzTZFTHSzFrpsz cmwllVqqGJbVVVmmqbQcmgRnRvGhGfgDRDZBBBvRdd nMvMhMnvhnbTZWSSZgHmGJDFmmNDzBmbNmdGBN rCsPLRCssRjrLLsrLlwRVrcNJQfDQfdBmmfNBGJNzmDPfB CRjCpLltgtJgJJWq jshCzJpjzTPpmCWvSlpfwHfSWglf LQMMNMnHtDtLVRvwwgRWlldgWD qHVrQNHVMFQtrrBBQMBcrrZsZbzCZhbbJZJsmmsmFPTC JZQZnsQNMqTngZqJBVfBfPPVBNrwvfPw SSmDstFjpDpCszDjcLLhrPVlGlrGGVBwrvwVPt FSssFcLjFjbmFFCzjLcFLRDnMJnTHRnZZTdWqZZWnMnRnZ GbHRHpldwGMpWhHpCMBlCbRdVSLhnqJLSrDPLPPLPDqVDrhh gvjWWQvgZFtQFFNqLnVnDnSJzzztDD ZccccfTsffHdWWdRWwsw ClCtbHMlnnPPlszV gSDWSLgWQWQJJNWqgtQjPsnfcdVcLVdVdzfzVzff WQgqtFQgDgQSFqJhqhSJvNDRrZMZHwHMCbZhTpZbGHMTMG pZJZlCQtHFhPfdNfCh zcmLSVczwcMcLDNFHdLPhPWH szvVVnBmnTGQtHTQ RVVCNDlNGzlGZqHGHWqWhGqQwH ZFLFTmpLvvmSqsbb TrfpBfJpJMlnnNfNZD qHHlDClHhltMqQsHDhHslGznwdTnzzwDGSdfnwGnwG mZRNcNcLLPNPBFFbbPmLmbZFSCVfJJTVndVfSwnRzznfTwCS CcCWFbbBLCWtgWgHjghqvv TjbzlnlFmfqCFFVVCRWr PhMcLpPDtMLpwPDvLPJbMhSgVCGqggVqQgCqCgCgSWvv btbZbNZhJDJJhDtwtsTTTmBzzBBmlNlmHj FqhjWtqlqmmsnFPTCvMCQMTTCjQd pfffRfLpgrgGgzrNVzzpGVzRCdMCPJbwwcVMbQPCJVMVdbww DGGDZRGrHggzSsFQnnWShmtH vtHVVMMrvVMVrSHvLgvlHcZFCnRCZcccZtRRZfJFCJ rdDjGsdTQDcNZfdncCRR rBDsTwBbjbmbbQswswPhqVmmSvpVhlvvqMhHhh vGBLrqMNvqSLBvvrNbllLHfwStWWtFttccjtRtjtcj MhCDJmhMDzmcRRcjzWfztH ZQDmDhVVCQbBVdVNMvvv ptCtCzhWPWptnhVzzpGZbZTjTjVjFGjVFgVl fQswRRffmRqZlgrqqFjjSgGg HwsQDNNsDsmRLLHmffsfvHptBnhtzCvhWpZWBdhnMdCh RlHzzTqczBPfbnvcpB wVtNwpSZstppwwMsZhsdnLvnbtBBmbnLFFdnmF WNQJMVWsZWwGJWhhSNrQzlgHrDCgQRHpCHrl RrZWpJZRrZpdTGstlchLGGlLMd NqjDPCQPnQCSvtMzSLhhjM nQVQDDDDfwBwNCVCNVFNpWpgJgrRTmLTmTmgRTWF SHMcrMHpcjGcjSrMMbvSvvSvwFTLJwJNtFGFWJNtDLFTLfWN zqRnPfzQCRzqsmRPzznhszzLtLwQwwFTgWWLDLgWFTwTNQ qVPZmRZhsCZPhZlRCqRRRCbfpccMBjvMVjdHjjMjSvdf VVQdHwBZLVltlddtBczhrzvGcWWFRwgsFG TDTTTqqTSSqjqnmTmPqPPmTmGhRszvsrzsjRsccgzrRzgWGF DpJPqpWqHbZpllpt cCSCFsnnZFnscDtNdJFJtJtdmb VgBqBsqRrHtNdzmNrt BGLLVVjRBsqPBfsGwPsMfSSZCSfTZTZQpSphfS plCHCHlgglHHGpNbtngNrDvBDpfQDBQfZDfWZVrr mTmMLhRfwhsLPQvQZDMZQBQWMB cwsssmqRTFFfFgtbCtGl LQPPrCPnMZwqtRMn cWTSlJWlcplJdDTdGdpDlGcGgqmtwwZtqRrNRRmRdNZqmgNq GSJcJSjsjTpsvWGWBHLLvVVBBBrFrzVz NVPCSPMNDSNFVSWCsJJJmpGmZZGLLcpZLHGGtsHt fwzlBBqghqvzqqlDrHbpHjZHmGZbLZrHLb dnBgnDqQvwRnSnnFMFMP BCbPsFFwCRHmDSBmWnvDDj phhZVzdpVfQZphhZpRhSVnjmrcvvnrWtDrvWDS TfQJMfLphMhJdfdzpQJRTPbwHHNlgbGwsTGgCP ttWLlnnvnNnBBtlTqWlpvpndQdZsQQFssFDdsRFdVdRNFQ jSgrScrbGZSGrrCGsFVMssFsPPFcDDMV bzSmJbfCZCbzLwllflwqtvvw zmFTJwFLPmzLztmjDzTJwfNrdFNrFppBSNRGNGdbrpBR gqlhWQgsZMsvqMlMMvsvqsNlLbcdppbrRpdbbcSrrbbr vssCgVgCsggZQZCgsnsqWgWvfJPDLwffwTPPmzTnjTPmPmwJ SpcRTPQLBLWpNNzjmmwwwRrR tGlfvGhfnbDlbqlChnfFMrwsmwNssTMHMHjFwv ZlhtCtffCdWcZWZVVT jTTCcWHWJNgCGTzTmnzrmnGn BwRRbFvtvvQmJJFMpMJr ZBBwLvqbBZsRsbVsZSqbcZdJjHHjhfPCJfJfHhgc VrnDSvvrLrfTdTLGfdRp zcJzmcFcHGfdGmWTVd tHsMhwPVctccHFHFcbSDbbPjnNbBnbvBQB QttWQwLTnLnWTtnffnLQSBFVjNvBjBFNgMdCsVWsjv pDqcmmRPHqgVBddjvN DcclzbcbPbJLnNTfnw plRcpsZDGlGZvWvMCNcLtttq SrfrwSjSVrSjwbmSrHzmHJCQQPQzqttNNQJMzJtqMW wSHVnfHfWwwHWFVfSnfgmmRsslFZZDBBGZsZsDTdGRTp qSFQSgQNgQBrBHHcrW VTmjVJLTwlTmwTVmsMJMVlJmPvcbvvbCBbGBPjGvBbBGWcbb DnJTZwmnZRhnpqNdWt dTVHjZLLZDVCfVHtLDDjQbscjWbSJMJPjsbWWb FnqrnmzzFllmsWwtsFtQMMFc lmqzzzngGmlNNBqGllzlBNRvptHHpTCHpDLpgDZdgvHvDD sdRZQbCfZTSTdlfTZCffccWPHPPcPPwLwctRnLWn BBJDzFVgCDrCJrqDJJhqJVVMLPHwcctFwcWHHGLcwGwGHnWc ghpJgqqjCZbQdZpd tbcpzbHSszcHBgqHGZgJJJhhww jfvdvRTffQQrrFCRFTnGwJRqNRZVpJGZLZggLh nQTjTnMndlTdQFMvnrClCnpzmzDtbbmBbcPSzzlmmtzP BqBqTCSTcqHsJHHM WWPGVPLtzVgWtjWPGzVjzVGcbDhPsRbDcsbJwNRswRDRss VQfWjfLFGWLjdFfVzTZZpJTpnmlTrSQlBl jLNsZjqSHCsGdsmpsm MvnVFzWMwMVWzfnVDwfBMfnnrCtdtPmPlRrdrJCJrtPDrrPD zznfFWwMfMfFMwVTMQFnQjhjgjSZhCNbLSTcHHgbbC GGtssttVmvnnGNMQrrVzgwVrCWMz FdhfhhcCDhHLfzclZMcrwcQMZM HHqqCBhHSSpdmjGqmGjtjtjj bbQLtGMQQtQRQtrDtGprrrbCqwplZhhqSqmdwvdzqqqhSmpS FsJjJBfnsJcFcFfjVPjWBzldqhqnlZZZzzhmnSvSnm JPcFfFWjFHJVVsVjPVscsDlLNRHGDbLRMRCDNrCGbG JdMdlMRJnTwdvcjv CDLHbNSzzLFgHvnTjrswBNBTNT QgbvzSFQmZQPQQRW NTBrNzrpjjjCwGbB FRbQlcvFvcRQQlRsMlRRRZjwCqMwjmjwJZdLJmjCZC cVPPQcvlWDNhrbPz VdbVtbbZJdtJVVdDVZmTLqqTSQvNLjjDShhvSG zplpnBnFpnrrlghGNpLNqHvqvjNj cWncllnlPFWzcMwtWWtsVLVRmJWCds ShLSTnZnTSttTSbLQdfSZTMwcDHwwcHnJvDHnlnlclMM NmPMsssRrVwjDclHJwwR gNNMWGzNmqGdtfZTbGGb sWNNlRHnmJtmntJt brbbBTbbFbCbqqGgBTrCfmQVVZfSSQQSVtJZSrVZ bbFqvbDvvGGLGbCCtBGDLbLlcPNHhhccPNcdPPchlsdR DCFvDvnCnNfMBmMMslDZML SQQQJHwpSgJSJHQWSWHqJWWbmcBBBLLTsmhhTcZbMhmlshcb RJRgpJHssgwSQHRqsQPGGjjtNCrrFvvnFjjPrP mThmsgjzTPjMpcvtWP GNNBVqVGNZbbNbNqqZQVNVNbWcpdtMCcpCtMWCdCPpQccmpp VSmNrmmbBfZVlsrssrLTRhRhTn TdmCvLDCpTRNTdFbbWnnSWCfhjbbzn GrrMsPVGcQHBGMbhjjSgWfHHDbjb BPBVqqrQPsQqwrrmmmJdRLDDqFRplT fpDDJljDlCfDTjprjrfbddWthCSCtdPPQFhSSSWW HsLZgMGbgBBsNzMvGbdVtVQzFRQSthhFPdtP sMBmGBmbNvLHGMnrDppTcJmcjpqljf ptSpSJQqpbNGGDDhcMWrlNHcZZWWls zRLRRRjvvgjHMMsMpWpc vmCPLCgwvwdnCzmvLbpTbVQqJJPbJPpTVq TJCfhhJVFffrJJQQllNWcvWhwvWD GPSGjjpLslBbpLpLqqqPDvdwvwvNzQWGzDDNdzGN msbRjbpPqsRpHnlZrmJlnVHT GGfFsCCTvGDsfTTrhsCMMzptZJMdpdgtrpdMcV LBlwBHPSqjwwlVggHpnMZcVHMt ZlZZlBbRPGGTGfmRsD CtCjbVvzQQZTWVdd MlSqWlmsmGBSHJHTDFHZ pcqsmsplwsqclwRtRWgtRnPPvb zCrzCrsdjrhGDCFqGDjRRPtpWfQQcpfQZcCZPp VSVwVMgLHHLTwMDTMMVnbWPRZQRcRQPptWnpbZcb MNBBBlSMvLVwTlVTFdNdhNhFsqsGDrzm rBLWTwTThWwVVDTwHBsZZWppvpGtpptppmRvFFFMFMfL qPPNCCbqcbcNqbqQjjJQqzjRpptmlpMGmMlJtftmtFHpMt QnCgzzQbbQqPcPQnncbdQdnVTwDssZgrShBTVgZZsBSDHT PFGJFqnfqmPgFJQPWdbLdpDRhbphWjDm rclNHvcrzCNwrWRprjdMMMph wsZHwZNvRRQsQqBV LqlGCPlPLTCPqqQlpqLlWfBfWgcHNRJRfWNsncGH VVtdwVtDDdVmhrdwSBmjbdzNHgfgJnNnsSnHsNffHgRsgR wVzhbjmDbDrwjdbztFDDthMCvqPppZQBQLZQTqTvFTvZ BnQnQFwRmRwmwdBSFDFnmSDVLCJTCTppVVmGLVTCLcgVpC ZlWvhvZjNrbNvqjNhlfPfqjCGHrsspggTpVLpsJCpcJVgg vPzNvqjWhqFzGSnRGMDG wZnMZzzZZchDRtVsqtCtwV WmWpWWmPPWrmrmBmWrTlTFPNVqVCRSDCQHcqVTtTqsSDSTSD PrppdFlWWlfrWmpWFffrdcGjJJGggnnhZGdLLgGGndvz FShHNmNhRhNJmBnQBQJrmP VTgzDTjwfffwzDvwlcczzVSJbQlBQSWBWCnPJPbJWWbC tzSVtzvSvGSRZqqFMNtpRR hPZhGDZpnCGtDhznjmLmdJffdNzJ glwsSrQwBvLdgLzdcj QsRbHllzzlHwHlBszWlTBFbpDPMhbPDVGpGFpPtFPp SRjStRDctgDSBzLvPvNrDhmPLr QqTHGTPJmmHmhNmH TGQZsTqFnQZCJTPsnJnZQMjVRBVtcVRSVRBlwccSCtBS bbsNsvsvnNPTRRllbblLqhtQCqQSLCGGHSqHNC wFpzFgqVzqVJWFDwqJDmSBBmHBHhShLQhCGSBCGH MJVpFMqgwMqRRbZsMbZMrP PPdDhvNDQdmgQPZmQVHHtHGGWVGbffWGvs MMLCTRRLlLclTLRMRLCwMLHWVctbVVHWWWFfVjVGsFWW MRSMMlpTJRqClBCRqBDnzqgQPnqgznZPZqbP MrMNPNNpjvdprWtrpMsthqBfqlnfqcGhVBqFRcnqFG QbDgSSQbgSDDmDVmlqSCRllRcFqnqfBl QVJbVmwwDQbzVTgbppNJNMWNjNNPrdpM WwJJNbtHfpLpVgZZPVFhZh vmmqlDvRvRfqBSrlzmmMjRBhcVhQVZhVghCQQQQTcTrPTP jSqMmqRzMDDjvqlBqsBMBmmwGNJwJnwLNfbGwddswnJtJH RLgRmRggbvbzzPmmRNmzsQWFtSGNtwSNQnntFwnnCw pDBrBHpHhlldphHBHhJVFSLnWWFJttCtQSttSS hfHrpphHBppfTvmzgMmbLbgf";

    public static String listStr = "2-5,15-90 42-93,43-57 71-95,72-81 19-92,2-93 21-92,57-93 57-75,76-76 66-92,14-76 4-97,5-96 22-50,22-51 10-43,42-43 50-59,60-60 81-86,86-94 86-98,82-99 44-63,44-62 36-65,42-89 2-86,14-85 51-51,48-52 41-55,10-55 3-99,3-96 62-64,38-63 24-80,80-98 13-67,7-47 22-78,21-91 3-92,26-91 97-98,86-98 17-90,16-91 4-96,97-97 33-46,44-47 98-98,44-96 9-36,7-13 17-91,18-90 1-37,4-37 19-58,18-58 42-43,11-42 9-98,10-97 6-22,5-6 9-12,13-61 4-16,17-24 37-45,36-38 62-86,61-61 8-41,8-40 35-91,35-98 84-85,72-84 40-90,41-91 47-58,31-59 30-80,22-31 87-89,58-90 13-25,14-25 23-54,52-53 4-89,5-88 3-99,1-2 4-54,3-53 4-33,5-52 50-92,49-50 72-98,71-97 7-27,26-27 10-49,39-78 3-93,16-92 16-30,31-96 6-90,5-6 5-93,4-99 7-99,8-95 49-89,50-90 43-43,38-42 23-78,6-79 89-90,31-89 3-8,7-25 26-54,26-27 64-87,64-97 25-53,25-53 17-77,17-78 58-88,59-82 7-30,6-29 9-95,1-10 31-98,26-97 3-9,10-55 19-19,19-35 81-86,22-86 51-69,52-70 17-82,17-82 30-41,30-52 32-36,17-34 12-60,15-61 5-85,6-86 26-95,25-95 2-94,94-95 37-37,38-76 39-59,38-38 8-98,7-97 15-95,14-94 63-65,27-64 18-62,61-61 8-82,8-82 75-75,74-75 63-98,63-98 68-86,12-69 41-88,53-91 18-81,94-94 67-99,66-67 41-42,42-50 39-40,4-39 11-12,12-20 43-48,40-49 10-10,11-49 8-50,8-49 42-42,43-94 30-94,6-32 15-92,15-15 4-88,1-40 5-13,11-15 5-76,1-6 1-3,3-92 6-92,9-91 74-98,73-99 10-13,13-35 26-81,27-82 13-69,12-93 6-44,6-43 22-88,88-89 48-58,47-71 23-24,22-24 2-47,7-42 28-55,27-56 20-93,93-93 61-76,26-60 63-98,63-97 26-29,25-30 69-79,9-69 18-98,17-97 51-59,50-51 2-98,3-97 26-92,11-26 15-20,26-89 18-42,41-41 1-95,1-96 9-98,97-97 99-99,3-99 3-99,3-96 3-70,3-71 14-65,14-39 2-96,97-99 21-58,22-57 7-64,35-63 4-83,83-83 23-74,75-99 98-98,1-99 38-94,38-94 65-77,78-78 12-50,49-49 32-84,84-85 9-35,9-35 11-50,39-51 7-98,9-96 30-57,29-56 61-69,25-61 7-81,17-82 5-35,35-35 11-79,12-78 35-76,35-77 25-36,19-36 79-92,37-91 4-4,3-97 10-12,15-30 36-64,37-63 11-14,13-83 13-82,92-96 6-6,16-71 17-75,10-29 25-74,25-73 67-92,59-91 81-83,64-82 88-88,37-87 45-76,36-52 2-13,12-92 24-25,25-31 5-95,1-4 11-55,4-10 32-91,32-90 77-77,11-77 20-64,20-63 45-63,49-62 20-99,19-91 13-67,5-14 29-49,24-40 12-67,12-68 98-98,5-99 28-51,52-56 2-99,38-99 17-50,16-16 8-84,9-85 67-92,26-67 68-69,69-70 18-54,19-19 2-93,3-80 2-28,27-42 47-81,37-48 25-35,34-35 26-94,16-20 26-92,27-93 46-92,4-47 91-91,18-91 24-48,35-56 5-94,5-94 84-95,46-83 5-95,95-97 91-93,18-92 15-46,16-47 3-33,4-34 4-91,4-71 14-27,15-92 71-92,92-92 18-70,19-71 46-68,47-69 30-31,29-83 28-89,29-98 11-90,12-95 65-70,28-68 23-77,70-76 21-44,45-90 50-50,1-49 60-94,61-93 24-89,23-72 15-93,3-16 12-78,11-77 11-20,68-92 51-86,52-63 29-41,29-29 6-96,5-95 45-91,44-90 23-26,22-27 7-82,7-82 47-61,48-93 7-7,8-88 31-73,30-46 22-85,22-86 8-17,18-62 10-77,11-77 15-94,14-93 5-78,2-2 24-53,23-52 61-79,62-80 97-98,59-97 69-99,34-58 2-93,1-94 88-88,89-99 15-15,14-16 20-20,21-25 40-60,15-61 18-25,84-86 8-99,56-97 12-98,6-49 1-48,2-47 34-44,33-43 68-94,67-95 3-56,23-56 12-35,12-33 23-79,24-43 13-92,13-92 60-96,29-97 17-87,2-17 29-61,43-61 51-93,82-93 19-95,19-94 13-14,14-81 19-19,20-40 31-93,31-93 9-94,8-93 46-85,46-99 5-51,6-52 53-80,52-53 7-57,39-59 79-90,90-90 72-93,26-69 1-97,1-96 18-79,18-50 72-72,42-71 54-95,54-99 86-94,34-93 20-77,21-77 88-90,26-89 23-83,23-84 7-7,7-40 35-35,18-36 67-85,68-86 22-59,21-58 28-72,27-32 13-13,1-12 9-90,9-89 24-69,25-70 67-67,40-68 1-9,15-96 7-48,6-47 36-67,48-54 2-4,10-95 4-89,15-97 28-63,34-48 81-81,80-80 18-87,87-88 94-94,8-95 77-92,71-97 41-41,42-90 3-36,4-35 3-91,96-96 89-91,9-35 1-82,1-1 15-83,15-82 4-92,4-93 93-94,32-93 82-93,96-99 15-32,15-39 60-64,59-65 68-72,72-73 65-72,27-64 16-17,17-35 7-19,7-67 31-98,30-94 93-99,30-96 18-88,18-85 18-45,17-77 4-45,4-44 74-82,40-73 8-92,7-7 18-86,86-86 30-60,30-50 42-78,39-78 10-79,44-78 8-96,8-39 8-64,13-65 92-93,30-92 4-94,1-2 91-97,92-98 41-97,42-97 2-97,2-70 28-79,5-79 30-30,31-68 6-97,99-99 10-10,9-20 3-96,2-94 3-8,8-47 99-99,52-99 2-31,1-6 2-89,2-82 22-95,29-94 92-94,27-93 1-2,2-87 53-54,53-54 1-66,41-62 7-42,1-26 7-98,8-97 26-99,26-92 2-95,3-94 93-93,12-94 21-23,9-22 43-97,43-96 45-72,74-83 26-94,25-93 32-32,31-71 21-21,20-98 4-98,26-98 8-63,62-88 2-82,6-97 11-48,10-53 54-54,55-93 38-39,3-38 75-77,74-76 35-98,8-35 13-83,84-97 13-21,7-21 2-17,16-78 79-79,21-79 25-87,87-88 53-90,89-90 11-38,37-37 4-42,41-41 2-2,3-98 52-72,52-71 16-22,13-21 16-91,2-7 4-61,29-46 10-91,1-59 28-93,27-93 88-99,27-89 27-87,88-88 10-66,10-67 12-13,12-42 80-89,81-91 39-85,39-84 82-82,83-97 24-46,47-63 26-74,27-73 4-92,2-3 1-88,1-88 29-94,29-68 29-96,28-82 51-51,52-80 13-41,12-26 3-51,17-50 17-46,45-45 16-25,97-99 20-42,26-47 21-49,40-44 6-80,1-31 74-86,68-85 32-98,1-99 7-30,6-30 70-79,24-71 64-97,28-49 23-93,24-94 29-42,28-28 91-95,91-96 9-41,10-40 83-93,31-94 42-94,41-76 75-77,9-76 64-93,92-93 68-68,69-69 14-21,19-20 89-89,4-90 8-10,9-59 20-83,10-86 37-89,38-88 8-99,5-8 8-50,20-49 50-74,49-50 20-92,19-93 52-78,36-53 63-96,62-63 15-47,16-46 87-88,4-88 45-66,44-67 49-54,48-94 27-35,28-35 67-91,66-90 2-99,1-60 16-85,15-84 9-93,92-95 4-38,37-39 7-16,3-16 33-41,33-67 19-34,33-34 79-85,85-86 68-99,80-89 4-70,11-81 19-80,19-19 15-64,63-64 17-50,18-54 14-87,13-13 51-89,52-98 73-90,12-91 30-93,2-94 80-81,8-81 51-80,81-87 75-83,97-97 13-89,14-27 1-2,3-46 93-94,54-93 11-84,11-85 17-30,2-6 15-65,64-69 64-74,10-69 9-95,10-94 70-91,69-92 27-96,26-95 39-48,8-10 46-49,45-46 54-82,35-54 1-1,2-86 81-93,10-80 88-93,42-93 33-33,33-82 9-55,56-73 1-93,2-92 97-97,2-95 1-94,71-94 26-54,59-66 35-86,15-36 2-55,4-66 50-87,26-49 43-87,19-43 4-96,3-97 20-90,53-89 16-88,4-87 64-64,11-63 38-65,39-39 11-31,12-32 25-60,24-43 24-47,26-48 3-92,91-91 87-95,87-90 91-92,4-91 74-77,74-76 2-96,96-99 26-42,26-59 4-5,7-65 64-71,44-64 33-83,29-82 19-32,18-28 2-95,1-95 28-95,28-95 9-72,10-73 50-96,96-97 19-52,19-60 9-78,8-9 53-54,2-53 36-86,4-37 47-60,59-60 80-81,43-81 21-60,22-61 27-78,26-77 57-93,57-94 1-92,95-96 12-94,11-93 4-99,1-47 28-28,29-92 34-86,54-87 62-81,63-80 13-98,97-99 30-30,29-55 29-72,29-94 4-98,4-4 48-50,49-49 12-12,3-13 42-91,41-91 59-63,60-64 6-61,7-54 23-94,15-24 6-98,6-97 21-96,20-21 18-68,18-68 27-40,27-27 16-99,3-17 67-82,32-51 98-98,26-77 29-96,96-97 3-31,1-32 52-60,18-55 6-88,5-95 84-90,84-86 19-83,18-97 1-50,49-51 94-94,23-95 40-40,5-40 29-30,29-29 13-49,12-50 28-76,27-75 40-55,40-57 9-9,10-98 6-75,4-4 4-95,5-96 46-47,31-47 44-62,43-61 29-75,18-95 37-72,37-73 49-67,49-66 55-78,56-79 9-54,53-55 3-65,4-64 37-37,4-37 29-55,30-56 6-95,4-96 78-80,79-81 15-59,14-15 61-62,55-62 50-96,17-32 12-96,11-96 9-9,10-33 36-89,97-99 37-59,38-58 32-51,33-54 72-74,39-73 77-99,77-94 5-31,28-29 22-96,21-21 2-94,3-95 6-97,6-98 53-69,44-52 29-90,30-91 4-26,7-24 18-26,27-91 20-96,19-97 22-28,23-27 18-74,17-90 36-70,36-94 57-77,20-58 10-36,11-80 23-23,23-99 7-87,88-88 12-13,13-62 4-38,2-5 53-55,2-54 30-87,4-87 33-34,34-51 86-90,39-86 51-51,52-89 7-42,8-8 31-34,17-35 4-77,33-78 9-33,14-82 39-83,40-82 15-72,26-72 77-93,92-92 14-81,80-81 81-96,97-97 27-28,28-86 50-83,37-50 67-96,67-98 23-91,23-91 25-83,24-84 43-82,43-48 88-88,37-88 97-98,2-96 9-98,97-97 20-33,20-33 9-26,15-99 1-4,3-61 42-75,67-75 29-94,29-60 70-70,70-89 1-92,1-92 53-74,73-75 80-80,2-81 1-98,3-99 1-92,3-91 15-88,16-89 7-97,8-96 2-5,5-66 3-83,2-82 45-94,45-45 20-26,26-92 2-47,47-52 31-70,30-30 48-71,48-90 24-95,95-95 32-83,82-83 26-59,18-40 90-92,2-91 16-73,17-65 17-97,18-99 33-33,31-33 1-97,14-50 24-96,25-95 62-62,33-62 32-32,33-68 62-81,61-91 26-55,8-25 24-64,16-23 50-64,49-49 30-94,93-93 84-95,36-83 82-97,41-83 11-33,10-32 19-27,27-50 17-60,18-61 31-85,85-85 45-70,46-69 1-6,5-84 17-86,12-60 48-94,97-99 91-96,90-90 12-75,82-99 10-77,77-78 5-7,6-97 93-98,92-98 25-36,25-67 36-37,37-70 38-58,59-92 88-88,67-89 3-91,3-90 9-71,8-70 26-70,27-70 84-86,31-85 34-83,2-33 14-58,14-50 47-81,48-82 90-91,77-91 91-92,39-91 76-78,30-77 22-53,21-22 16-87,86-87 1-3,3-41 18-27,27-27 4-97,4-4 64-67,64-67 12-13,1-13 37-59,36-36 10-96,9-10 66-67,41-66 12-45,11-66 78-94,79-95 7-95,52-95 85-85,17-84 46-57,47-58 18-74,1-59 22-63,34-39 6-73,12-80 33-85,16-83 4-47,4-47 4-4,5-67 18-65,9-17 13-88,13-89 60-79,61-69 97-98,11-95 12-96,12-75 18-18,18-88 27-81,82-98 48-48,49-84 16-58,57-57 83-84,84-96 32-42,49-93 99-99,3-97 1-95,95-96 56-68,55-55 2-2,2-49 27-59,35-58 43-86,44-86 20-75,19-75 14-95,1-14 6-93,93-94 16-95,15-16 11-16,16-90 80-80,62-79 11-51,10-51 66-91,67-81 39-42,39-43 14-18,17-19 50-54,50-55 4-71,3-54 2-98,1-99 69-71,20-69 3-52,28-53 9-45,8-46 94-95,29-94 8-89,14-90 89-91,2-90 1-58,14-85 25-25,25-74 29-82,82-82 84-97,6-83 31-92,91-91 45-78,45-92 55-58,55-78 8-85,7-84 44-90,43-82 45-58,44-58 20-27,27-85 51-69,52-70 29-50,30-49 3-3,4-54 69-73,70-72 6-7,7-92 3-8,3-97 6-65,83-85 78-81,39-78 23-47,24-40 72-74,28-73 2-2,1-96 67-93,66-94 32-33,10-33 33-89,33-46 22-39,24-39 63-74,64-86 2-39,4-21 28-71,72-84 3-64,64-64 15-69,16-68 49-86,44-80 44-80,45-79 20-20,9-21 28-41,6-28 16-54,15-53 51-93,50-82 63-70,69-71 26-79,43-78 7-59,1-9 59-63,50-63 57-58,11-58 6-91,4-5 15-20,5-16 2-79,8-34 90-90,69-90 39-67,38-50 3-79,3-80 5-97,4-98 32-97,23-31 11-98,11-99 20-75,75-76 76-77,36-77 55-55,54-93 93-94,49-94 5-96,4-5 91-93,19-73 35-77,11-93 21-43,21-44 34-83,84-84 4-38,5-33 7-7,8-48 3-96,2-96 11-90,2-11 28-79,28-79 6-96,1-35 17-30,17-17 52-52,30-53 83-94,82-93 11-13,7-14 96-96,75-96 46-59,6-60 25-76,75-76 91-91,90-90 62-87,61-88 16-69,17-68 36-43,39-42 8-87,7-87 73-75,42-74 91-98,81-92 23-95,22-22 93-95,53-94 5-92,91-93 21-41,40-41 12-97,12-98 7-98,8-99 13-97,13-96 61-62,62-74 43-45,23-44 43-45,46-74 32-69,32-69 54-56,53-56 2-76,3-77 11-74,11-73 22-75,16-22 8-80,79-81 8-27,9-28 66-80,79-86 43-43,44-97 2-74,2-8 11-78,78-80 59-82,83-91 94-94,94-99 2-86,2-2 35-35,34-98 61-63,61-85 22-76,21-77 9-35,35-69 44-79,45-78 31-66,66-67 17-95,96-97 47-79,38-48 28-94,13-39 39-73,38-73 35-64,14-55 53-95,8-96 24-94,15-25 83-84,55-83 41-68,41-67 78-91,15-74 52-79,83-91 6-9,10-98 9-37,7-7 39-47,40-47 25-97,23-39 88-88,11-89 10-88,9-88 9-84,7-7 6-91,6-6 66-75,44-74 16-85,86-90 42-57,31-41 39-74,73-96 13-87,87-88 25-26,26-27 3-11,4-12 46-74,3-74 21-96,95-97 47-64,47-57 9-42,10-43 28-77,29-78 20-38,37-71 45-98,44-96 10-61,15-59 8-98,6-6 13-67,12-66 2-97,3-3 27-28,28-44 13-67,67-89 8-71,70-71 15-49,15-52 11-75,3-10 85-85,50-86 21-88,25-76 45-71,70-77 5-81,4-84 15-64,14-15 3-95,2-3 36-46,35-45 4-23,5-22 24-48,47-48 6-27,2-58 36-58,37-82 6-66,3-56 3-29,28-71 43-83,43-87 22-79,21-90 27-45,45-58 3-37,4-36 8-9,10-81 24-99,74-99 9-42,8-43 2-98,3-99 75-76,60-75 29-83,28-28 18-26,26-26 78-95,9-77 7-71,2-72 22-88,87-89 26-28,71-73 93-96,51-89 65-65,66-96 11-19,18-98 27-62,32-65 18-69,17-19 55-56,35-56 25-71,26-70 3-96,3-95 25-96,40-95 95-95,3-96 47-65,63-66 45-53,39-45 5-84,6-79 31-91,14-85 24-31,32-54 11-48,48-62 38-51,10-52 4-90,5-89 9-44,10-15 5-11,10-98 2-4,5-18 1-98,79-98 63-90,89-90 60-69,58-60 37-95,37-98 30-77,31-78 10-21,20-39 11-30,31-64 39-86,85-87 67-79,42-74 11-76,75-91 5-30,30-57 88-90,58-89 19-90,20-91 1-1,3-12 95-95,23-96 40-76,40-76 26-46,26-46 8-56,79-79 28-81,28-88 3-65,49-64 15-51,15-15 44-78,43-64 6-82,5-83 19-56,19-56 24-52,24-51 14-88,13-14 26-97,89-97 13-86,13-87 52-80,51-52 27-55,12-48 56-82,80-85 2-29,3-29 18-87,3-87 6-35,2-6 28-36,37-97 75-87,75-87 1-99,2-2 48-48,48-88 59-92,80-95 82-87,6-83 81-97,13-81 13-75,14-75 97-98,21-97 14-93,13-13 21-32,20-31 30-71,72-72 51-75,41-75 24-84,23-85 11-11,11-21 62-81,62-81 1-3,3-98 75-78,78-79 17-96,18-96 9-98,5-99 18-49,48-48 66-66,40-66 18-72,17-73 6-87,87-88 3-44,4-45 31-54,54-79 55-59,54-58 6-6,7-15 21-98,20-99 1-2,3-30 72-77,20-77";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String[] list = listStr.split(" ");
        Integer count = 0;

        for (String s : list) {
            String[] arr = s.split(",");
            String[] pair1Str = arr[0].split("-");
            String[] pair2Str = arr[1].split("-");
            Integer pair1Min = Integer.parseInt(pair1Str[0]);
            Integer pair1Max = Integer.parseInt(pair1Str[1]);
            Integer pair2Min = Integer.parseInt(pair2Str[0]);
            Integer pair2Max = Integer.parseInt(pair2Str[1]);

            if (pair1Max >= pair2Min
             && pair1Max <= pair2Max
             || pair1Min >= pair2Min
             && pair1Min <= pair2Max
             || pair2Min >= pair1Min
             && pair2Min <= pair1Max
             || pair2Max >= pair1Min
             && pair2Max <= pair1Max
            ) {

                    LOG.info("______________________________NEW OVERLAPS______________________________________________________________");
                    LOG.info("pair1Max: " + pair1Max);
                    LOG.info("pair1Min: " + pair1Min);
                    LOG.info("pair2Min: " + pair2Min);
                    LOG.info("pair2Max: " + pair2Max);
                    count++;

            }
        }
        return count.toString();

    }
}
