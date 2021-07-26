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
import freemarker.template.TemplateExceptionHandler;

public class PrintUtils
{

	/**
	 *
	 * @return
	 * @throws Exception
	 */
	public static Configuration getConfig() throws Exception
	{
		try
		{
			final Configuration cfg = new Configuration();
			cfg.setDirectoryForTemplateLoading(new File("D:\\azahar\\dev\\code\\jsf-practice-project\\src\\main\\resources\\templates"));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			return cfg;
		}
		catch (final Exception e)
		{
			throw e;
		}

	}

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
			if (outputFile.exists())
			{

				outputFile.delete();

				outputFile.createNewFile();
				final ITextRenderer iTextRenderer = new ITextRenderer();
				// final Document document = Jsoup.parse(inputHtml);
				iTextRenderer.setDocument(inputHtml);
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
	public static <T> void printToPdf(final List<T> t, final Map<String, Object> root, final String FileName)
	{
		try
		{
			final Configuration cfg = PrintUtils.getConfig();
			final Template template = cfg.getTemplate("test.xhtml");
			final String htmlFilePath = "D:\\azahar\\dev\\code\\jsf-practice-project\\src\\testoutputs\\" + FileName + ".html";
			final String OutputFilePath = "D:\\azahar\\dev\\code\\jsf-practice-project\\src\\testoutputs\\" + FileName + ".pdf";

			final FileWriter out = new FileWriter(htmlFilePath);
			template.process(root, out);
			out.close();
			System.out.println(FileName + ".html has been created in path: " + htmlFilePath);
			PrintUtils.htmlToPdf(htmlFilePath, OutputFilePath);

		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}
}
