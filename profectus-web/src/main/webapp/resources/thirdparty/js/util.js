
/**
 * Allow only numbers.
 * @param e
 * @returns {Boolean}
 */function onlyNumber(e) {
    if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        return false;
    }
}

/**
 * Allow only words and numbers.
 * @param e
 * @returns {Boolean}
 */function onlyWordAndNumber(e) {
	 
	 //if (!ereg("^([A-Z,a-z,0-9,_,-]){4,}", e) ) {
		    //alert("Senha com caracteres inválidos");
		//}
	 
    if(e.which == 95 || e.which == 32 || (e.which > 64 && e.which < 91)
        ||(e.which > 96 && e.which < 123)){
        return true;
    } else if(e.which > 47 && e.which < 58){
        return true;
    } else {
        if (e.which != 8) {
            return false;
        } else {
            return true;
        }
    }
    
    $(nameField).keydown(function(evt) {
        if (evt.ctrlKey == true) {
            return false;
        }
    });

}

 /**
  * Allow only words and numbers and mathematical signs.
  * @param e
  * @returns {Boolean}
  */function onlyWordAndNumberMathematicalSigns(e) {
	  
     if(e.which == 37 ||
        e.which == 94 || 
    	e.which == 95 ||
       (e.which > 31 && e.which < 36) ||
       (e.which > 39 && e.which < 48) ||
       (e.which > 59 && e.which < 63) ||
       (e.which > 64 && e.which < 91) ||
       (e.which > 96 && e.which < 123)){
       
    	 return true;
     } else if(e.which > 47 && e.which < 58){
         return true;
     } else {
         if (e.which != 8) {
             return false;
         } else {
             return true;
         }
     }
 }
 
 
 
/**
 * No space in first character.
 * @param nameField
 */
function noSpaceFirstChar(nameField){
    $(nameField).blur(function(evt) {
        var field = $(this).val();

        while(field.length > 0 && field.charAt(0) == " ") {
            field = field.substring(1);
        }

        $(this).val(field);
    });

    $(nameField).keypress(function(evt) {
        var field = $(this).val();

        if(field.length == 0 && evt.which == 32){
            return false;
        } else {
            return true;
        }
    });
}

/**
 * Allow only words and numbers.
 * @param e
 * @returns {Boolean}
 */
function blockSpace(e) {
    if(e.which == 32){
        return false;
    } else {
        return true;
    }
}

function blockComma(e) {
    if(e.which === 44){
        return false;
    } else {
        return true;
    }
}


/**
 * Bloqueia a tecla Ctrl.
 *
 * @param nameField
 */
function blockCtrlKey(nameField){
    $(nameField).keydown(function(evt) {
        if (evt.ctrlKey == true) {
            return false;
        }
    });
}

/**
 * Bloqueia a colar com o mouse.
 *
 * @param nameField
 */
function blockPasteWithMouse(nameField){
    $(nameField).bind("contextmenu", function(event) {
        return false;
    });
}

/**
 * Força a formatação da de uma data.
 *
 * @param nameField
 */
function onlyDateFormat(nameField){
    $(nameField).keypress(function (evt) {
        var vlr = String.fromCharCode(evt.which);
        var field = $(nameField).val();
        var expr = new RegExp("^\d*[0-9]");
        var expr1 = new RegExp("^\d*[0-1]");
        var expr2 = new RegExp("^\d*[0-2]");
        var expr3 = new RegExp("^\d*[0-3]");

        if (evt.which == 8) {
            return true;
        } else if(field.length == 0 && vlr == 0) {
            return false;
        } else if(field.length == 1) {
            if (field == 1 && vlr < 9) {
                return false;
            }
        }else if(field.length == 4 || field.length == 7) {
            if (evt.which != 45) {
                return false;
            }
        } else if(field.length == 5) {
            if (!expr1.test(vlr)) {
                return false;
            }
        } else if(field.length == 6) {
            var mes = field.charAt(5);

            if(mes == 0 && vlr == 0) {
                return false;
            } else if (mes == 1 && !expr2.test(vlr)) {
                return false;
            }
        } else if(field.length == 8) {
            var mes = field.substring(5, 7);

            if (!expr3.test(vlr)) {
                return false;
            }

            if(parseInt(mes) == 2 && !expr2.test(vlr)) {
                return false;
            }
        } else if(field.length == 9) {
            //var meses = [4, 6, 9, 11]; Modificado por conta do IE7
            var dia = field.substring(8);
            var ano = field.substring(0, 4);
            var mes = parseInt(field.substring(5, 7));

            if (dia == 0 && vlr == 0) {
                return false;
            } else if (dia == 3) {
                if (!expr1.test(vlr)) {
                    return false;
                }

                if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && vlr == 1) {
                    return false;
                }
            } else if (mes == 2) {
                if(vlr == 9 && ((ano % 4) != 0)) {
                    return false;
                } else if (!expr.test(vlr)) {
                    return false;
                }
            }
        } else if(field.length > 9 || !expr.test(vlr)) {
            return false;
        }
    });
}

/**
 * Força a formatação da de uma data.
 *
 * @param nameField
 */
function onlyDateFormatThis(nameField){
    $(nameField).keypress(function (evt) {
        var vlr = String.fromCharCode(evt.which);
        var field = $(this).val();
        var expr = new RegExp("^\d*[0-9]");
        var expr1 = new RegExp("^\d*[0-1]");
        var expr2 = new RegExp("^\d*[0-2]");
        var expr3 = new RegExp("^\d*[0-3]");

        if (evt.which == 8) {
            return true;
        } else if(field.length == 0 && vlr == 0) {
            return false;
        } else if(field.length == 1) {
            if (field == 1 && vlr < 9) {
                return false;
            }
        }else if(field.length == 4 || field.length == 7) {
            if (evt.which != 45) {
                return false;
            }
        } else if(field.length == 5) {
            if (!expr1.test(vlr)) {
                return false;
            }
        } else if(field.length == 6) {
            var mes = field.charAt(5);

            if(mes == 0 && vlr == 0) {
                return false;
            } else if (mes == 1 && !expr2.test(vlr)) {
                return false;
            }
        } else if(field.length == 8) {
            var mes = field.substring(5, 7);

            if (!expr3.test(vlr)) {
                return false;
            }

            if(parseInt(mes) == 2 && !expr2.test(vlr)) {
                return false;
            }
        } else if(field.length == 9) {
            //var meses = [4, 6, 9, 11]; Modificado por conta do IE7
            var dia = field.substring(8);
            var ano = field.substring(0, 4);
            var mes = parseInt(field.substring(5, 7));

            if (dia == 0 && vlr == 0) {
                return false;
            } else if (dia == 3) {
                if (!expr1.test(vlr)) {
                    return false;
                }

                if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && vlr == 1) {
                    return false;
                }
            } else if (mes == 2) {
                if(vlr == 9 && ((ano % 4) != 0)) {
                    return false;
                } else if (!expr.test(vlr)) {
                    return false;
                }
            }
        } else if(field.length > 9 || !expr.test(vlr)) {
            return false;
        }
    });
    
    $(nameField).blur(function (event) {
	    var field = $(this).val();
	
	    if(field.length == 10) {
	
	        var dia = parseInt(field.substring(8, 10), 10);
	        var mes = parseInt(field.substring(5, 7), 10);
	        var ano = parseInt(field.substring(0, 4), 10);
	
	        if(ano >= 1900) {
	            if(ano == 0) {
	                $(this).val('');
	            } else if(mes == 0 || mes > 12) {
	                $(this).val('');
	            } else if(dia == 0 || dia > 31) {
	                $(this).val('');
	            } else {
	                if((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia == 31) {
	                    $(this).val('');
	                } else if(mes == 2) {
	                    if(dia == 29 && ((ano % 4) != 0)) {
	                        $(this).val('');
	                    } else if(dia == 30 || dia == 31) {
	                        $(this).val('');
	                    }
	                }
	            }
	        } else {
	            $(this).val('');
	        }
	    } else {
	        $(this).val('');
	    }
    });
}

/**
 * Allow only words and numbers.
 * @param e
 * @returns {Boolean}
 */function variableNameValidate(e) {
    if((e.which > 64 && e.which < 91) || (e.which > 96 && e.which < 123)){
        return true;
    } else if(e.which > 47 && e.which < 58){
        return true;
    } else if(e.which == 95 || e.which == 8){
        return true;
    } else {
        return false;
    }
}

function onlyNumberInPaste(nameField){
    $(nameField).keyup(function() {
        var re = $(nameField).val();
        //if(re.match(['\?,./{}"<>() ][-@!#$%¨&*+_´`^~;:?áÁéÉíÍóÓúÚãÃçÇ|abcdefghijklmnopqrstuvxyzwABCDEFGHIJKLMNOPQRSTUVXYWZ'])) {
        if(re.match(['[-@!#$%¨&*+_´`^~;:?áÁéÉíÍóÓúÚãÃçÇabcdefghijklmnopqrstuvxyzwABCDEFGHIJKLMNOPQRSTUVXYWZ|?,./\\{}<>()]'])) {
            $(nameField).val('');
        }
    });

    $(nameField).keypress(function (evt) {
        if (evt.which == 92) {
            return false;
        }
    });

    $(nameField).blur(function (event) {
        var re = $(nameField).val();
        if(re.match(['[-@!#$%¨&*+_´`^~;:?áÁéÉíÍóÓúÚãÃçÇabcdefghijklmnopqrstuvxyzwABCDEFGHIJKLMNOPQRSTUVXYWZ|?,./\\{}<>()]'])) {
            $(nameField).val('');
        }
    });
}

function onlyNumberCtrlV(nameField){
    $(nameField).change(function() {
        var re = $(nameField).val();
        //if(re.match(['\?,./{}"<>() ][-@!#$%¨&*+_´`^~;:?áÁéÉíÍóÓúÚãÃçÇ|abcdefghijklmnopqrstuvxyzwABCDEFGHIJKLMNOPQRSTUVXYWZ'])) {
        if(re.match(['[-@!#$%¨&*+_´`^~;:?áÁéÉíÍóÓúÚãÃçÇabcdefghijklmnopqrstuvxyzwABCDEFGHIJKLMNOPQRSTUVXYWZ|?,./\\{}<>()]'])) {
            $(nameField).val('');
        }
    });
}

/**
 * Bloqueia a tecla Ctrl.
 *
 * @param nameField
 */

$('.fieldDateFee').keydown(function(event) {
    if (event.ctrlKey == true) {
        return false;
    }
});

/**
 * Bloqueia a colar com o mouse.
 *
 * @param nameField
 */

$('.fieldDateFee').bind("contextmenu", function(event) {
    return false;
});


/**
 * Força a formatação de uma data.
 *
 * @param nameField
 */

$('.fieldDateFee').keypress(function (event) {
    var vlr = String.fromCharCode(event.which);
    var field = $(this).val();
    var expr = new RegExp("^\d*[0-9]");
    var expr1 = new RegExp("^\d*[0-1]");
    var expr2 = new RegExp("^\d*[0-2]");
    var expr3 = new RegExp("^\d*[0-3]");

    if (event.which == 8) {
        return true;
    } else if(field.length == 0 && vlr == 0) {
        return false;
    } else if(field.length == 1) {
        if (field == 1 && vlr < 9) {
            return false;
        }
    }else if(field.length == 4 || field.length == 7) {
        if (event.which != 45) {
            return false;
        }
    } else if(field.length == 5) {
        if (!expr1.test(vlr)) {
            return false;
        }
    } else if(field.length == 6) {
        var mes = field.charAt(5);

        if(mes == 0 && vlr == 0) {
            return false;
        } else if (mes == 1 && !expr2.test(vlr)) {
            return false;
        }
    } else if(field.length == 8) {
        var mes = field.substring(5, 7);

        if (!expr3.test(vlr)) {
            return false;
        }

        if(parseInt(mes) == 2 && !expr2.test(vlr)) {
            return false;
        }
    } else if(field.length == 9) {
        //var meses = [4, 6, 9, 11]; Modificado por conta do IE7
        var dia = field.substring(8);
        var ano = field.substring(0, 4);
        var mes = parseInt(field.substring(5, 7));

        if (dia == 0 && vlr == 0) {
            return false;
        } else if (dia == 3) {
            if (!expr1.test(vlr)) {
                return false;
            }

            if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && vlr == 1) {
                return false;
            }
        } else if (mes == 2) {
            if(vlr == 9 && ((ano % 4) != 0)) {
                return false;
            } else if (!expr.test(vlr)) {
                return false;
            }
        }
    } else if(field.length > 9 || !expr.test(vlr)) {
        return false;
    }
});

/**
 * Valia a data ao sair o focus do campo.
 *
 * @param nameField
 */

$('.fieldDateFee').blur(function (event) {
    var field = $(this).val();

    if(field.length == 10) {

        var dia = parseInt(field.substring(8, 10), 10);
        var mes = parseInt(field.substring(5, 7), 10);
        var ano = parseInt(field.substring(0, 4), 10);

        if(ano >= 1900) {
            if(ano == 0) {
                $(this).val('');
            } else if(mes == 0 || mes > 12) {
                $(this).val('');
            } else if(dia == 0 || dia > 31) {
                $(this).val('');
            } else {
                if((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia == 31) {
                    $(this).val('');
                } else if(mes == 2) {
                    if(dia == 29 && ((ano % 4) != 0)) {
                        $(this).val('');
                    } else if(dia == 30 || dia == 31) {
                        $(this).val('');
                    }
                }
            }
        } else {
            $(this).val('');
        }
    } else {
        $(this).val('');
    }
});

/*******************************/
/***** Tratamento de horas *****/
/*******************************/

function validateHourPurge(nameField){
    /**
     * Bloqueia a tecla Ctrl.
     *
     * @param nameField
     */

    $(nameField).keydown(function (event) {
        if (event.ctrlKey == true) {
            return false;
        }
    });

    /**
     * Bloqueia a colar com o mouse.
     *
     * @param nameField
     */

    $(nameField).bind("contextmenu", function(event) {
        return false;
    });

    /**
     * Força a formatação de uma hora.
     *
     * @param nameField
     */

    $(nameField).keypress(function (event) {
        var field = $(this).val();
        var vlr = String.fromCharCode(event.which);
        var expr1h = new RegExp("^\d*[0-2]");
        var expr2h = new RegExp("^\d*[0-3]");
        var expr2h9 = new RegExp("^\d*[0-9]");

        if (event.which == 8) {
            return true;
        } else if(field.length == 0) {
            if (!expr1h.test(vlr)) {
                return false;
            }
        } else if(field.length == 1) {
            var h = parseInt(field);
            if(h == 2) {
                if (!expr2h.test(vlr)) {
                    return false;
                }
            } else{
                if (!expr2h9.test(vlr)) {
                    return false;
                }
            }
        } else if(field.length == 2) {
            if (event.which != 58) {
                return false;
            }
        } else if(field.length > 2) {
            if (vlr != 0) {
                return false;
            }
        }
    });

    /**
     * Valia a hora ao sair o focus do campo.
     *
     * @param nameField
     */

    $(nameField).blur(function (event) {
        var field = $(this).val();

        if(field.length == 5) {
            var hour = parseInt(field.substring(0, 2));
            var minute = parseInt(field.substring(3));

            if(hour >= 0 && hour < 24) {
                if(minute == 0) {
                    return true;
                }
            }
        } else if(field.length == 4) {
            var hour = parseInt(field.substring(0, 1));
            var minute = parseInt(field.substring(2));

            if(hour >= 0 && hour < 9) {
                if(minute == 0) {
                    $(this).val('0' + field);

                    return true;
                }
            }
        } else if(field.length == 2) {
            var hour = parseInt(field);

            if(hour >= 0 && hour < 24) {
                $(this).val(field + ':00');
                return true;
            }
        } else if(field.length == 1) {
            var hour = parseInt(field);

            if(hour >= 0 && hour < 9) {
                $(this).val('0' + field + ':00');
                return true;
            }
        }

        $(this).val('');
    });
}


function setMaxlengthFieldValue(){
	
		var variableSize = $("[name='variableDTO.variableSize']").val();
	
		if(variableSize != null){
			$("[name='variableDTO.value']").attr('maxlength', variableSize);
		}
		
		if(variableSize == "" || variableSize == null){
			return false;
		}
}
