package main.java.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

import freemarker.template.Configuration;
import freemarker.template.Template;
import test.TestPdfExport;

public class PrintUtils
{
	/**
	 *
	 * @param inputHtml
	 * @param outputFileName
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	private static void htmlToPdf(final String inputHtml, final String OutputFilePath) throws FileNotFoundException, DocumentException
	{

		try
		{

			final File outputFile = new File(OutputFilePath);
			outputFile.exists();
			if (outputFile.exists() && outputFile.isFile())
			{
				final ITextRenderer iTextRenderer = new ITextRenderer();
				iTextRenderer.setDocument(new File(inputHtml));
				iTextRenderer.layout();
				final OutputStream os = new FileOutputStream(outputFile);
				iTextRenderer.createPDF(os);
				System.out.println("Pdf has been created in path: " + OutputFilePath);

				os.close();
			}
		}
		catch (final Exception e)
		{

			e.printStackTrace();
		}

	}

	/**
	 *
	 * @param t
	 * @param root
	 * @param FileName
	 */
	public static <T> void printTodPdf(final List<T> t, final Map<String, Object> root, final String FileName)
	{
		try
		{
			final Configuration cfg = TestPdfExport.getConfig();
			final Template template = cfg.getTemplate("test.xhtml");
			final String htmlFilePath = "D:\\azahar\\dev\\code\\jsf-practice-project\\src\\testoutputs\\" + FileName + ".html";
			final String OutputFilePath = "D:\\azahar\\dev\\code\\jsf-practice-project\\src\\testoutputs\\" + FileName + ".pdf";

			final FileWriter out = new FileWriter(htmlFilePath);
			template.process(root, out);
			System.out.println(FileName + ".html has been created in path: " + htmlFilePath);
			PrintUtils.htmlToPdf(htmlFilePath, OutputFilePath);

			out.close();

		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}
}
