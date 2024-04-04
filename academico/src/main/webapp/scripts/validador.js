/**
 * Validacao para evitar submissão sem valor de matrícula informado
 * @author Alencar Júnior
 */
 
function validar() {
	let matri = document.getElementById('matricula').value
	if (matri.trim() === '') {
		alert('Informe um número de matrícula!')
		matricula.focus()
		return false
	}
	
	return true
}