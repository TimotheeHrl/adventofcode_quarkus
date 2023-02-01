package org.acme;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

import static io.quarkus.arc.ComponentsProvider.LOG;

@Path("/hello")
public class GreetingResource {
//public static String listStr = "BzRmmzZHzVBzgVQmZLPtqqffPqWqJmPLlL hpvvTDcrCjhpcrvcGGhfLHMlLtMCqflNlWPJlJ hGjhncHhGnhbTHczBBZVVSbRwgSgRV rWVQjPQQjGRWNSrWrPjcptwBpqqJBtJBBcZgMdtq zzmmpzfTCFpTlMlJJwBgMlqMBt TvLszpbhhTLmsnRQPDQGWDWRvQSR zGzvLlGlQHLGBQZlhBWhdjRdmdWRcjPj fTJNfTfNSRWPhjdjfj pbsbVVnpSnbVTprnbqqrzvLLgQlGLPLHll ZCCCsWvNvmsCsCmZLZmgMLRpQMhwQRpQRfphfprpTfpM tlncPjzlndctbzcPPBcjwDphwrfGGDffbDRpDTGG cdqnddwzqjNVWVLZZLZq DTLbDbRrlQbwhhNrmmfwdt zzMJMzjCjJJjvLjMPJpcgPpzfhHdfqWcqddwtwfqdttcNtdN pJCzVpCvDZBLsVRQ STzBBbJzRRBZBRTqCCsfZLtNNLClCsfh jsQnnQjjHcvQFrcPwCmtLCNlvDfftfff sGFscMQQMMpqzqbMbd QlNDWGsjQjgQllWQsbtzqTJczTJcbFmmFJJP MhLrhgLVndRmzJFzVqqJqP pSLnMdwhwdRZRSwhLZwLhdGWQjlsgWjNQWWSvgBsWDlj THjSRFSddTjdBTcPLcVVvVBw GzWnWfndWfznDfsnsBsPVwVwPPLL zNflzJWqqzQDdSStHNZNpFFtbj FSzDmsFSFlDlBzqVjqHHjHHpVgHLbp rTrTtTQQntRQnQJQgggHZttVgHLBLhZL WTJJRRQCRRJTRdBCRdvRNDFSWFMPmDlPPSsNPSzS WQldlMtMVQgVMQHnDGbHGGnRnQmD rqcZPrCFjmHlbGjZ zSScchqwchBzTzFzhhSlcCwNtdVWWJgsVdMtWNgNVWTJTd lMZqjMWllrTTspjprWWSSwgWNSVNDmWGVwFwgN cdCCdLHcnndHJnmCRntLBnRzDvFNtNDVzgSgwDgFNVzFVv BRLcCCJCmJdcRhfjPPZphrlrPqlZ GdGqcrrZGDrvDJJqJHcBvmFFgmFMMgMgBtMLTssLmF NbPVPDlljPmTmsTj VfQDhflCCRWdcrQwJvvnJv RLcWgLCqqPQLcqZwzHgwmmrmmtgwTw DhbhNrMpnJSDJwVTHmmTVnTTVj lrsvblMDlcWcfQPQ PVldlphHwGwJJGdjZZWsRbbsGsNWrWQbNbQR SqcDvTmDLtfmSmtqppfqzTgTQBrRQsbCFWbNNFQFBBrRbLNb MgtmTgtfpqVlnVddZMwV BdmfmPBPSbSNdGSdvWrwcZrccZPPcZnH jzzLsjsMRlQQVHwswvvZrCHrrT VqhzVFzplFlpLwpMphLRQQVRmSqgbdGtNJBmNSmgGbtggSgt DHVpNZjdZjFZWVFHpvFvzmlRzPnlfznFRz lrTBTsBwwMbrrwLPPfwGmGzvRf scrtMhMCtJBBBclbHdHttWZWDSqDSjHj wzqsPmqsbsfqBwPMNRMMZcZmFFNtZM CgCnhlvvLJgcRFNNBdCpWM QnQrVgHSvVHjbjTGBbbTHb HdrVrdqFDdZVmHgRmDRFHMnTdTssMGnLnPJLbPTbCs SczlScjwcNzplNzQSSfjwQSrTGGsbTsnTCnGTMCMLMGGbN wQlfjrhfhQFHqZhRZRtD RsfJDGJvzPNcjpddSWJWMd LLCbBCwCrCmVVnrmhQFmbVhdcdlWpjZzSpMdWSpcWczSBj rrLCbTwnHTvzvNGT wPhPhbCqqSCrtJDlqvlrJr RVVZddLFRZZcQLvJJtzptlgPJp TVQRZGVncFdTGWZdCNShHhfPNwwsWPwb dzLVzPSgrgDDDCMSMLLPwFmdTTcsvmwNwjNsHcFF nWBGntQfGNGBflWBBqlpRQGbWFvjwsbsFswbvTHjjbmHTc tBNJBnGBflQnDPJrPhDgrPVg VtWztWtqpqzWpWzqjNRjNpWTmrrmrSbnmJwSJwnMPrCSJVwM sDHsBDhBdsBZGcHvLHDLhhCSnRSwCJMZrPbmnMbJSCSR ccLRhgsLBdRsdHNTFFNNgqTglqzF hztlmDhPhgPlPNNgmZMCbmwwQjcwjjwMjVCd RSJRrRqnqQJFqvnTGrHCcHHCCHHbHHMcMvdM qGJsnQTRsStsftPlhPNl BFFBLPRCwsLwhlPlRmhcGGrbmmGjfNTTnp VJMVpzgqggJnrjmjNcMjmT VqdSZtQgZvtdzqHqHtVZdVQpCDWWFdwlRPDpWPPBCswlWD fCWCsjPzcbzwRSzVTzhhDLqvdg TmJtrNJrBLSLJqgS ptNTQFHrZlnpFPwsWMbRjCpcjR nJmQNCmbmlllmbClbfMLjMFqbGBsdLFq ZcgTWcTnMqqMTBqF tPgctSnPctZZgDWzZgQHwNmHlhlmzlQhlJlw ZpTCwpffdslvgShCBhqhRz FDMPnNFNmBPzvRPRBg nNgMrnnDGjDmJMmnFdZTTsdsrZrslcwcQr pTmczpCldcdDDnPttpvWSqbpJf jgjRZMGHhGLgQrjvPWzPJgJvzStbbq LGNLLNBBzcDFCBwwFC nJTTqnrNvTzNMzzNfqrTPrJnwpwPpZpsHccZVsBRpcVHwpcp bgDhgbghLWmFmStctVpZtBCVCCpfZp LLSgLGSjggFGbSSbmMnrvqvzjfzTNrJrqM RRpDmmPMTjwfGmJQgQ WsNscdnvvdVZFVnnrZbjjflwljlbzfGFjQjq NnLZsNnrrVVVcvdBLTPCPCRMwhPMBMPhCt lbVvzngGJnVbJHpHtHNPpdSQvc TsMBswFZsWMWBZMNwPtNNtRNHcNpSQ CcZCTrZDsjZTsTsshWhrWrTnfgbLDfJzVVLVVlgfnzfVGV JzTTRtJRZWmWjrMHCT DDFGlLGcGlSSSLsFGBspPBmNMBHMghmWNmWjWCmWtH nSSpnbsGlLDnpPsSSspFtVvffRQdVzqvvbqdfVQwRz sMhzszlHHDsWbthHDqsbJjpLNtmjVJmVLLVLVLBp nrTPrGwfPLdprzJzdL wgPQcTGGzgccwCgnRwgRChFhlWSDqWWQMWhssSsMQl NSNmwtpSpCpvMphCsr PHcRGPLJMrsvzsqG QHjbnRMcfbPbQZmlZgZlgBBQ cPRPbhQjbQRdtPQdLqLHqzFZjCFCqLjC mmfsnnwrfvwrfSNZFzHHLDCFNlLlqDlN wsmrwswwGTffMrBnmQttJtcMZQQtPJPbZc MvBPDDRRdnnvHPCHZLHZsFLL rmJcbVqbcjWwWjQHLzTZFTHSzFrpsz cmwllVqqGJbVVVmmqbQcmgRnRvGhGfgDRDZBBBvRdd nMvMhMnvhnbTZWSSZgHmGJDFmmNDzBmbNmdGBN rCsPLRCssRjrLLsrLlwRVrcNJQfDQfdBmmfNBGJNzmDPfB CRjCpLltgtJgJJWq jshCzJpjzTPpmCWvSlpfwHfSWglf LQMMNMnHtDtLVRvwwgRWlldgWD qHVrQNHVMFQtrrBBQMBcrrZsZbzCZhbbJZJsmmsmFPTC JZQZnsQNMqTngZqJBVfBfPPVBNrwvfPw SSmDstFjpDpCszDjcLLhrPVlGlrGGVBwrvwVPt FSssFcLjFjbmFFCzjLcFLRDnMJnTHRnZZTdWqZZWnMnRnZ GbHRHpldwGMpWhHpCMBlCbRdVSLhnqJLSrDPLPPLPDqVDrhh gvjWWQvgZFtQFFNqLnVnDnSJzzztDD ZccccfTsffHdWWdRWwsw ClCtbHMlnnPPlszV gSDWSLgWQWQJJNWqgtQjPsnfcdVcLVdVdzfzVzff WQgqtFQgDgQSFqJhqhSJvNDRrZMZHwHMCbZhTpZbGHMTMG pZJZlCQtHFhPfdNfCh zcmLSVczwcMcLDNFHdLPhPWH szvVVnBmnTGQtHTQ RVVCNDlNGzlGZqHGHWqWhGqQwH ZFLFTmpLvvmSqsbb TrfpBfJpJMlnnNfNZD qHHlDClHhltMqQsHDhHslGznwdTnzzwDGSdfnwGnwG mZRNcNcLLPNPBFFbbPmLmbZFSCVfJJTVndVfSwnRzznfTwCS CcCWFbbBLCWtgWgHjghqvv TjbzlnlFmfqCFFVVCRWr PhMcLpPDtMLpwPDvLPJbMhSgVCGqggVqQgCqCgCgSWvv btbZbNZhJDJJhDtwtsTTTmBzzBBmlNlmHj FqhjWtqlqmmsnFPTCvMCQMTTCjQd pfffRfLpgrgGgzrNVzzpGVzRCdMCPJbwwcVMbQPCJVMVdbww DGGDZRGrHggzSsFQnnWShmtH vtHVVMMrvVMVrSHvLgvlHcZFCnRCZcccZtRRZfJFCJ rdDjGsdTQDcNZfdncCRR rBDsTwBbjbmbbQswswPhqVmmSvpVhlvvqMhHhh vGBLrqMNvqSLBvvrNbllLHfwStWWtFttccjtRtjtcj MhCDJmhMDzmcRRcjzWfztH ZQDmDhVVCQbBVdVNMvvv ptCtCzhWPWptnhVzzpGZbZTjTjVjFGjVFgVl fQswRRffmRqZlgrqqFjjSgGg HwsQDNNsDsmRLLHmffsfvHptBnhtzCvhWpZWBdhnMdCh RlHzzTqczBPfbnvcpB wVtNwpSZstppwwMsZhsdnLvnbtBBmbnLFFdnmF WNQJMVWsZWwGJWhhSNrQzlgHrDCgQRHpCHrl RrZWpJZRrZpdTGstlchLGGlLMd NqjDPCQPnQCSvtMzSLhhjM nQVQDDDDfwBwNCVCNVFNpWpgJgrRTmLTmTmgRTWF SHMcrMHpcjGcjSrMMbvSvvSvwFTLJwJNtFGFWJNtDLFTLfWN zqRnPfzQCRzqsmRPzznhszzLtLwQwwFTgWWLDLgWFTwTNQ qVPZmRZhsCZPhZlRCqRRRCbfpccMBjvMVjdHjjMjSvdf VVQdHwBZLVltlddtBczhrzvGcWWFRwgsFG TDTTTqqTSSqjqnmTmPqPPmTmGhRszvsrzsjRsccgzrRzgWGF DpJPqpWqHbZpllpt cCSCFsnnZFnscDtNdJFJtJtdmb VgBqBsqRrHtNdzmNrt BGLLVVjRBsqPBfsGwPsMfSSZCSfTZTZQpSphfS plCHCHlgglHHGpNbtngNrDvBDpfQDBQfZDfWZVrr mTmMLhRfwhsLPQvQZDMZQBQWMB cwsssmqRTFFfFgtbCtGl LQPPrCPnMZwqtRMn cWTSlJWlcplJdDTdGdpDlGcGgqmtwwZtqRrNRRmRdNZqmgNq GSJcJSjsjTpsvWGWBHLLvVVBBBrFrzVz NVPCSPMNDSNFVSWCsJJJmpGmZZGLLcpZLHGGtsHt fwzlBBqghqvzqqlDrHbpHjZHmGZbLZrHLb dnBgnDqQvwRnSnnFMFMP BCbPsFFwCRHmDSBmWnvDDj phhZVzdpVfQZphhZpRhSVnjmrcvvnrWtDrvWDS TfQJMfLphMhJdfdzpQJRTPbwHHNlgbGwsTGgCP ttWLlnnvnNnBBtlTqWlpvpndQdZsQQFssFDdsRFdVdRNFQ jSgrScrbGZSGrrCGsFVMssFsPPFcDDMV bzSmJbfCZCbzLwllflwqtvvw zmFTJwFLPmzLztmjDzTJwfNrdFNrFppBSNRGNGdbrpBR gqlhWQgsZMsvqMlMMvsvqsNlLbcdppbrRpdbbcSrrbbr vssCgVgCsggZQZCgsnsqWgWvfJPDLwffwTPPmzTnjTPmPmwJ SpcRTPQLBLWpNNzjmmwwwRrR tGlfvGhfnbDlbqlChnfFMrwsmwNssTMHMHjFwv ZlhtCtffCdWcZWZVVT jTTCcWHWJNgCGTzTmnzrmnGn BwRRbFvtvvQmJJFMpMJr ZBBwLvqbBZsRsbVsZSqbcZdJjHHjhfPCJfJfHhgc VrnDSvvrLrfTdTLGfdRp zcJzmcFcHGfdGmWTVd tHsMhwPVctccHFHFcbSDbbPjnNbBnbvBQB QttWQwLTnLnWTtnffnLQSBFVjNvBjBFNgMdCsVWsjv pDqcmmRPHqgVBddjvN DcclzbcbPbJLnNTfnw plRcpsZDGlGZvWvMCNcLtttq SrfrwSjSVrSjwbmSrHzmHJCQQPQzqttNNQJMzJtqMW wSHVnfHfWwwHWFVfSnfgmmRsslFZZDBBGZsZsDTdGRTp qSFQSgQNgQBrBHHcrW VTmjVJLTwlTmwTVmsMJMVlJmPvcbvvbCBbGBPjGvBbBGWcbb DnJTZwmnZRhnpqNdWt dTVHjZLLZDVCfVHtLDDjQbscjWbSJMJPjsbWWb FnqrnmzzFllmsWwtsFtQMMFc lmqzzzngGmlNNBqGllzlBNRvptHHpTCHpDLpgDZdgvHvDD sdRZQbCfZTSTdlfTZCffccWPHPPcPPwLwctRnLWn BBJDzFVgCDrCJrqDJJhqJVVMLPHwcctFwcWHHGLcwGwGHnWc ghpJgqqjCZbQdZpd tbcpzbHSszcHBgqHGZgJJJhhww jfvdvRTffQQrrFCRFTnGwJRqNRZVpJGZLZggLh nQTjTnMndlTdQFMvnrClCnpzmzDtbbmBbcPSzzlmmtzP BqBqTCSTcqHsJHHM WWPGVPLtzVgWtjWPGzVjzVGcbDhPsRbDcsbJwNRswRDRss VQfWjfLFGWLjdFfVzTZZpJTpnmlTrSQlBl jLNsZjqSHCsGdsmpsm MvnVFzWMwMVWzfnVDwfBMfnnrCtdtPmPlRrdrJCJrtPDrrPD zznfFWwMfMfFMwVTMQFnQjhjgjSZhCNbLSTcHHgbbC GGtssttVmvnnGNMQrrVzgwVrCWMz FdhfhhcCDhHLfzclZMcrwcQMZM HHqqCBhHSSpdmjGqmGjtjtjj bbQLtGMQQtQRQtrDtGprrrbCqwplZhhqSqmdwvdzqqqhSmpS FsJjJBfnsJcFcFfjVPjWBzldqhqnlZZZzzhmnSvSnm JPcFfFWjFHJVVsVjPVscsDlLNRHGDbLRMRCDNrCGbG JdMdlMRJnTwdvcjv CDLHbNSzzLFgHvnTjrswBNBTNT QgbvzSFQmZQPQQRW NTBrNzrpjjjCwGbB FRbQlcvFvcRQQlRsMlRRRZjwCqMwjmjwJZdLJmjCZC cVPPQcvlWDNhrbPz VdbVtbbZJdtJVVdDVZmTLqqTSQvNLjjDShhvSG zplpnBnFpnrrlghGNpLNqHvqvjNj cWncllnlPFWzcMwtWWtsVLVRmJWCds ShLSTnZnTSttTSbLQdfSZTMwcDHwwcHnJvDHnlnlclMM NmPMsssRrVwjDclHJwwR gNNMWGzNmqGdtfZTbGGb sWNNlRHnmJtmntJt brbbBTbbFbCbqqGgBTrCfmQVVZfSSQQSVtJZSrVZ bbFqvbDvvGGLGbCCtBGDLbLlcPNHhhccPNcdPPchlsdR DCFvDvnCnNfMBmMMslDZML SQQQJHwpSgJSJHQWSWHqJWWbmcBBBLLTsmhhTcZbMhmlshcb RJRgpJHssgwSQHRqsQPGGjjtNCrrFvvnFjjPrP mThmsgjzTPjMpcvtWP GNNBVqVGNZbbNbNqqZQVNVNbWcpdtMCcpCtMWCdCPpQccmpp VSmNrmmbBfZVlsrssrLTRhRhTn TdmCvLDCpTRNTdFbbWnnSWCfhjbbzn GrrMsPVGcQHBGMbhjjSgWfHHDbjb BPBVqqrQPsQqwrrmmmJdRLDDqFRplT fpDDJljDlCfDTjprjrfbddWthCSCtdPPQFhSSSWW HsLZgMGbgBBsNzMvGbdVtVQzFRQSthhFPdtP sMBmGBmbNvLHGMnrDppTcJmcjpqljf ptSpSJQqpbNGGDDhcMWrlNHcZZWWls zRLRRRjvvgjHMMsMpWpc vmCPLCgwvwdnCzmvLbpTbVQqJJPbJPpTVq TJCfhhJVFffrJJQQllNWcvWhwvWD GPSGjjpLslBbpLpLqqqPDvdwvwvNzQWGzDDNdzGN msbRjbpPqsRpHnlZrmJlnVHT GGfFsCCTvGDsfTTrhsCMMzptZJMdpdgtrpdMcV LBlwBHPSqjwwlVggHpnMZcVHMt ZlZZlBbRPGGTGfmRsD CtCjbVvzQQZTWVdd MlSqWlmsmGBSHJHTDFHZ pcqsmsplwsqclwRtRWgtRnPPvb zCrzCrsdjrhGDCFqGDjRRPtpWfQQcpfQZcCZPp VSVwVMgLHHLTwMDTMMVnbWPRZQRcRQPptWnpbZcb MNBBBlSMvLVwTlVTFdNdhNhFsqsGDrzm rBLWTwTThWwVVDTwHBsZZWppvpGtpptppmRvFFFMFMfL qPPNCCbqcbcNqbqQjjJQqzjRpptmlpMGmMlJtftmtFHpMt QnCgzzQbbQqPcPQnncbdQdnVTwDssZgrShBTVgZZsBSDHT PFGJFqnfqmPgFJQPWdbLdpDRhbphWjDm rclNHvcrzCNwrWRprjdMMMph wsZHwZNvRRQsQqBV LqlGCPlPLTCPqqQlpqLlWfBfWgcHNRJRfWNsncGH VVtdwVtDDdVmhrdwSBmjbdzNHgfgJnNnsSnHsNffHgRsgR wVzhbjmDbDrwjdbztFDDthMCvqPppZQBQLZQTqTvFTvZ BnQnQFwRmRwmwdBSFDFnmSDVLCJTCTppVVmGLVTCLcgVpC ZlWvhvZjNrbNvqjNhlfPfqjCGHrsspggTpVLpsJCpcJVgg vPzNvqjWhqFzGSnRGMDG wZnMZzzZZchDRtVsqtCtwV WmWpWWmPPWrmrmBmWrTlTFPNVqVCRSDCQHcqVTtTqsSDSTSD PrppdFlWWlfrWmpWFffrdcGjJJGggnnhZGdLLgGGndvz FShHNmNhRhNJmBnQBQJrmP VTgzDTjwfffwzDvwlcczzVSJbQlBQSWBWCnPJPbJWWbC tzSVtzvSvGSRZqqFMNtpRR hPZhGDZpnCGtDhznjmLmdJffdNzJ glwsSrQwBvLdgLzdcj QsRbHllzzlHwHlBszWlTBFbpDPMhbPDVGpGFpPtFPp SRjStRDctgDSBzLvPvNrDhmPLr QqTHGTPJmmHmhNmH TGQZsTqFnQZCJTPsnJnZQMjVRBVtcVRSVRBlwccSCtBS bbsNsvsvnNPTRRllbblLqhtQCqQSLCGGHSqHNC wFpzFgqVzqVJWFDwqJDmSBBmHBHhShLQhCGSBCGH MJVpFMqgwMqRRbZsMbZMrP PPdDhvNDQdmgQPZmQVHHtHGGWVGbffWGvs MMLCTRRLlLclTLRMRLCwMLHWVctbVVHWWWFfVjVGsFWW MRSMMlpTJRqClBCRqBDnzqgQPnqgznZPZqbP MrMNPNNpjvdprWtrpMsthqBfqlnfqcGhVBqFRcnqFG QbDgSSQbgSDDmDVmlqSCRllRcFqnqfBl QVJbVmwwDQbzVTgbppNJNMWNjNNPrdpM WwJJNbtHfpLpVgZZPVFhZh vmmqlDvRvRfqBSrlzmmMjRBhcVhQVZhVghCQQQQTcTrPTP jSqMmqRzMDDjvqlBqsBMBmmwGNJwJnwLNfbGwddswnJtJH RLgRmRggbvbzzPmmRNmzsQWFtSGNtwSNQnntFwnnCw pDBrBHpHhlldphHBHhJVFSLnWWFJttCtQSttSS hfHrpphHBppfTvmzgMmbLbgf";
public static String listStr ="vJrwpWtwJgWrhcsFMMfFFhFp jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL PmmdzqPrVvPwwTWBwg wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn ttgJtRGJQctTZtZT CrZsJsPPZsGzwwsLwLmpwMDw";
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
       String[] list = listStr.split(" ");
        Map<String, Integer[]> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
           int rucksack = list[i].length()/2;
              String[] firstHalf = list[i].substring(0, rucksack).split("");
              String[] secondHalf = list[i].substring(rucksack).split("");
            LOG.info("______________________________"+ " " + i + " " + list[i] + "_______________________________________");
           // compare the two arrays

            for(int j = 0; j < firstHalf.length; j++) {
                List<Character> charsToKeepInMind = new ArrayList<>();
                  for (int k = 0; k < secondHalf.length; k++) {
                      if (firstHalf[j].equals(secondHalf[k])) {
                          Integer[] itemNumber = map.get(firstHalf[j]);
                          if(itemNumber == null) {
                              itemNumber = new Integer[]{0, 0};
                          }

                              Character c = firstHalf[j].charAt(0);
                         if(!charsToKeepInMind.contains(c)) {
                          charsToKeepInMind.add(c);
                          LOG.info("firstHalf: " + Arrays.toString(firstHalf));
                          LOG.info("secondHalf: " + Arrays.toString(secondHalf));
                          LOG.info("new mach: "+" " +firstHalf[j] + " "+ itemNumber[0]+ " " + 1);
                          if (c >= 'a' && c <= 'z') {
                                  int pos = c - 'a' + 1;
                                  LOG.info("pos"+" "+ c+" " + pos);
                                  Integer newSum =  itemNumber[1] + pos;
                                  Integer[] mapItemValues = new Integer[]{itemNumber[0] + 1, pos};
                                  map.put(firstHalf[j], mapItemValues);

                              } else if (c >= 'A' && c <= 'Z') {
                                  int pos = c - 'A' + 1 + 26;
                                  LOG.info("Pos"+" "+ c+" " + pos);
                                  Integer newSum =  itemNumber[1] + pos;
                                  Integer[] mapItemValues = new Integer[]{itemNumber[0] + 1, pos};
                                  map.put(firstHalf[j], mapItemValues);

                          }
                      }
                      }
                  }
              }
        }
       // sump up the values of the map
        Integer sum = 0;
        for (Map.Entry<String, Integer[]> entry : map.entrySet()) {
            sum += entry.getValue()[1];
        }
        return sum.toString()  ;
    }
}