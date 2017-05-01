function configureDataTable(element, noSortColumns) {
    $(element).dataTable( {
        "sDom": "<'rowTopTable'<'pagination-right pull-right'p>r>t<'row-fluid actions-toolbar'<'actions-toolbar-inner'<'span4'<'control-group'l>><'span4'i><'pagination-right'<'span4'p>>>>",
        "bPaginate": true,
        "sPaginationType": "bootstrap",
        "iDisplayLength": 10,
        "bSortClasses": true,
        //"iDisplayStart": 0,
        "aLengthMenu": [ 10, 25, 50, 100 ],
        // Grid columns that won't be sorted.
        "aoColumnDefs": [{ "bSortable": false, "aTargets": noSortColumns }],
        "oLanguage": {
            "sProcessing":   "Processando...",
            "sLengthMenu":   "Mostrar _MENU_ registros",
            "sZeroRecords":  "N&atilde;o foram encontrados resultados",
            "sInfo":         "Mostrando de _START_ at&eacute; _END_ de _TOTAL_ registros",
            "sInfoEmpty":    "N&atilde;o existem registros a serem exibidos",
            "sInfoFiltered": "(filtrado de _MAX_ registros no total)",
            "sInfoPostFix":  "",
            "sSearch":       "Nome:",
            "oPaginate": {
                "sFirst":    "Primeiro",
                "sPrevious": "Ant",
                "sNext":     "Pr&oacute;x",
                "sLast":     "&Uacute;ltimo"
            }
        }
    });
}

function configureDataTableWithDefaultSort(element, noSortColumns, defaultColumnSort) {
    $(element).dataTable( {
        "sDom": "<'rowTopTable'<'pagination-right pull-right'p>r>t<'row-fluid actions-toolbar'<'actions-toolbar-inner'<'span4'<'control-group'l>><'span4'i><'pagination-right'<'span4'p>>>>",
        "bPaginate": true,
        "sPaginationType": "bootstrap",
        "iDisplayLength": 10,
        "bSortClasses": true,
        //"iDisplayStart": 0,
        "aLengthMenu": [ 10, 25, 50, 100 ],
        // Grid columns that won't be sorted.
        "aoColumnDefs": [{ "bSortable": false, "aTargets": noSortColumns }],
        "aaSorting": [[defaultColumnSort, "asc"]],
        "oLanguage": {
            "sProcessing":   "Processando...",
            "sLengthMenu":   "Mostrar _MENU_ registros",
            "sZeroRecords":  "N&atilde;o foram encontrados resultados",
            "sInfo":         "Mostrando de _START_ at&eacute; _END_ de _TOTAL_ registros",
            "sInfoEmpty":    "N&atilde;o existem registros a serem exibidos",
            "sInfoFiltered": "(filtrado de _MAX_ registros no total)",
            "sInfoPostFix":  "",
            "sSearch":       "Nome:",
            "oPaginate": {
                "sFirst":    "Primeiro",
                "sPrevious": "Ant",
                "sNext":     "Pr&oacute;x",
                "sLast":     "&Uacute;ltimo"
            }
        }
    });
}

function configureDataTableWithFilter(element, noSortColumns) {
	
	
    $(element).dataTable( {
        //"sDom": "<'rowTopTable'<'pagination-right pull-right'p>r>t<'row-fluid actions-toolbar'<'actions-toolbar-inner'<'span4'<'control-group'l>><'span4'i><'pagination-right'<'span4'p>>>>",
        "bPaginate": true,
        "sPaginationType": "bootstrap",
        "iDisplayLength": 10,
        "bSortClasses": true,
        //"iDisplayStart": 0,
        "aLengthMenu": [ 10, 25, 50, 100 ],
        // Grid columns that won't be sorted.
        "aoColumnDefs": [{ "bSortable": false, "aTargets": noSortColumns }],
        "oLanguage": {
            "sProcessing":   "Processando...",
            "sLengthMenu":   "Mostrar _MENU_ registros",
            "sZeroRecords":  "N&atilde;o foram encontrados resultados",
            "sInfo":         "Mostrando de _START_ at&eacute; _END_ de _TOTAL_ registros",
            "sInfoEmpty":    "N&atilde;o existem registros a serem exibidos",
            "sInfoFiltered": "(filtrado de _MAX_ registros no total)",
            "sInfoPostFix":  "",
            "sSearch": "Filtro:",
            "oPaginate": {
                "sFirst":    "Primeiro",
                "sPrevious": "Ant",
                "sNext":     "Pr&oacute;x",
                "sLast":     "&Uacute;ltimo"
            }},
        "oSearch": {"sSearch": "",
            		"oValidationOptions" : 
                       { 
                           rules:{ 
                                   value: {
                                           maxlength: 5
                                          }
                           },
                           messages: { 
                                   value: {
                                           maxlength: "Enter at least 5 characters" 
                                           } 
                           }
                       }
        		}
    });
    
   
    ///$('.dataTables_filter input').prop("placeholder", "enter search terms here");
    $('.dataTables_filter input').attr('maxlength','20');
    		
    
}

function configureDataTableInsideForm(element, noSortColumns) {
	
    $(element).dataTable( {
    	"sDom": "t<'row-fluid actions-toolbar'<'actions-toolbar-inner'<'span4'<'control-group'l>><'span4'i><'pagination-right'<'span4'p>>>>",
		"bPaginate": true,
        "sPaginationType": "bootstrap",
        "iDisplayLength": 10,
        "bSortClasses": true,
        //"iDisplayStart": 0,
        "aLengthMenu": [ 10, 25, 50, 100 ],
        // Grid columns that won't be sorted.
        "aoColumnDefs": [{ "bSortable": false, "aTargets": noSortColumns }],
        "oLanguage": {
            "sProcessing":   "Processando...",
            "sLengthMenu":   "Mostrar _MENU_ registros",
            "sZeroRecords":  "N&atilde;o foram encontrados resultados",
            "sInfo":         "Mostrando de _START_ at&eacute; _END_ de _TOTAL_ registros",
            "sInfoEmpty":    "N&atilde;o existem registros a serem exibidos",
            "sInfoFiltered": "(filtrado de _MAX_ registros no total)",
            "sInfoPostFix":  "",
            "sSearch":       "Nome:",
            "oPaginate": {
                "sFirst":    "Primeiro",
                "sPrevious": "Ant",
                "sNext":     "Pr&oacute;x",
                "sLast":     "&Uacute;ltimo"
            }
        }
    });
}

function configureDataTableInsideFormWithoutPagination(element, noSortColumns) {
	
    $(element).dataTable( {
    	"sDom": "t<'row-fluid actions-toolbar'<'actions-toolbar-inner'<'span4'<'control-group'l>><'span4'i>>>",
		"bPaginate": true,
        "sPaginationType": "bootstrap",
        "iDisplayLength": 10,
        "bSortClasses": true,
        //"iDisplayStart": 0,
        "aLengthMenu": [ 10, 25, 50, 100 ],
        // Grid columns that won't be sorted.
        "aoColumnDefs": [{ "bSortable": false, "aTargets": noSortColumns }],
        "oLanguage": {
            "sProcessing":   "Processando...",
            "sLengthMenu":   "Mostrar _MENU_ registros",
            "sZeroRecords":  "N&atilde;o foram encontrados resultados",
            "sInfo":         "Mostrando de _START_ at&eacute; _END_ de _TOTAL_ registros",
            "sInfoEmpty":    "N&atilde;o existem registros a serem exibidos",
            "sInfoFiltered": "(filtrado de _MAX_ registros no total)",
            "sInfoPostFix":  "",
            "sSearch":       "Nome:",
            "oPaginate": {
                "sFirst":    "Primeiro",
                "sPrevious": "Ant",
                "sNext":     "Pr&oacute;x",
                "sLast":     "&Uacute;ltimo"
            }
        }
    });
}

function configureDataTableWithFilterable(element, noSortColumns) {
    $(element).dataTable( {
        "sDom": "<'rowTopTable'<'pagination-right pull-right'p>r>t<'row-fluid actions-toolbar'<'actions-toolbar-inner'<'span4'<'control-group'l>><'span4'i><'pagination-right'<'span4'p>>>>",
        "bPaginate": true,
        "sPaginationType": "bootstrap",
        "iDisplayLength": 10,
        "bSortClasses": true,
        "bfilterSelector": true, 
        "bfilterClearSelector": true,
        //"iDisplayStart": 0,
        "aLengthMenu": [ 10, 25, 50, 100 ],
        // Grid columns that won't be sorted.
        "aoColumnDefs": [{ "bSortable": false, "aTargets": noSortColumns }],
        "oLanguage": {
            "sProcessing":   "Processando...",
            "sLengthMenu":   "Mostrar _MENU_ registros",
            "sZeroRecords":  "N&atilde;o foram encontrados resultados",
            "sInfo":         "Mostrando de _START_ at&eacute; _END_ de _TOTAL_ registros",
            "sInfoEmpty":    "N&atilde;o existem registros a serem exibidos",
            "sInfoFiltered": "(filtrado de _MAX_ registros no total)",
            "sInfoPostFix":  "",
            "sSearch":       "Nome:",
            "oPaginate": {
                "sFirst":    "Primeiro",
                "sPrevious": "Ant",
                "sNext":     "Pr&oacute;x",
                "sLast":     "&Uacute;ltimo"
            }
        }
    });
}