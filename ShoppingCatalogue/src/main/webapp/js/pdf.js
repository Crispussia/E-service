 function getPDF() {
	const recap = document.getElementById("recap");
    const pdf = new jspdf('p', 'pt', 'letter');
    pdf.canvas.height = 72 * 11;
    pdf.canvas.width = 72 * 8.5;
    
   
    pdf.fromHTML(recap);
    pdf.save('facture.pdf');
}