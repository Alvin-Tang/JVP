package com.jvp.web.builder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.web.bind.annotation.RequestMapping;

import com.jvp.core.Annotation.Column;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.Version;

public class Builder {

	static final ResourceBundle RESOURCE = ResourceBundle
			.getBundle("templateConfig");
	static final Version VERSION = Configuration.VERSION_2_3_23;
	static final String ENCODED = RESOURCE.getString("encoded");
	static final String TEMPLATE_PATH = RESOURCE.getString("template_path");
	static final String TEMPLATE_VIEW = RESOURCE.getString("template_view");
	static final String TEMPLATE_JS = RESOURCE.getString("template_js");
	static final String TEMPLATE_CSS = RESOURCE.getString("template_css");
	static final String CONTROLLER_PATH = RESOURCE.getString("controller_path");
	static final String VIEW_TARGET_PATH = RESOURCE
			.getString("view_target_path");
	static final String JS_TARGET_PATH = RESOURCE
			.getString("js_target_path");
	static final String CSS_TARGET_PATH = RESOURCE
			.getString("css_target_path");
	static final String DEFAULT_TARGET_PATH = RESOURCE
			.getString("default_target_path");
	static final String CLASS_PATH = RESOURCE.getString("class_path");
	static final String CLASS_NAME = RESOURCE.getString("class_name");

	public static void main(String[] args) {
		Builder builder = new Builder();
		builder.view();
		builder.js();
		builder.css();
	}

	public void view() {
		try {
			String[] class_names = CLASS_NAME.split(",");
			for (String c_name : class_names) {
				String targetPath = getTargetPath(c_name);
				if (targetPath != "") {
					targetPath = VIEW_TARGET_PATH + targetPath;
				} else {
					targetPath = DEFAULT_TARGET_PATH;
				}
				Template template = initTemplate(TEMPLATE_VIEW);
				Writer out = initWriterStream(targetPath + ".ftl");
				Map<String, Object> context = initContext(CLASS_PATH + "."
						+ c_name);
				template.process(context, out);
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void js() {
		try {
			String[] class_names = CLASS_NAME.split(",");
			for (String c_name : class_names) {
				String targetPath = getTargetPath(c_name);
				if (targetPath != "") {
					targetPath = JS_TARGET_PATH + targetPath;
				} else {
					targetPath = DEFAULT_TARGET_PATH;
				}
				Template template = initTemplate(TEMPLATE_JS);
				Writer out = initWriterStream(targetPath + ".js");
				Map<String, Object> context = null;
				template.process(context, out);
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void css() {
		try {
			String[] class_names = CLASS_NAME.split(",");
			for (String c_name : class_names) {
				String targetPath = getTargetPath(c_name);
				if (targetPath != "") {
					targetPath = CSS_TARGET_PATH + targetPath;
				} else {
					targetPath = DEFAULT_TARGET_PATH;
				}
				Template template = initTemplate(TEMPLATE_CSS);
				Writer out = initWriterStream(targetPath + ".css");
				Map<String, Object> context = null;
				template.process(context, out);
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String, Object> initContext(String className) throws Exception {
		Map<String, Object> context = new HashMap<String, Object>();
		try {
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Field[] fields = Class.forName(className).getDeclaredFields();
			for (Field field : fields) {
				Map<String, String> map = new HashMap<String, String>();
				Column column = field.getAnnotation(Column.class);
				if (column == null) {
					continue;
				}
				map.put("name", field.getName());
				map.put("cnName", column.name());
				map.put("required", column.required());
				map.put("type", column.type());
				map.put("valid", column.valid());
				map.put("hidden", column.hidden());
				list.add(map);
			}
			context.put("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return context;
	}

	public Template initTemplate(String templateName) throws Exception {
		try {
			Configuration config = new Configuration(VERSION);
			config.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
			config.setObjectWrapper(new DefaultObjectWrapper(VERSION));
			Template template = config.getTemplate(templateName, ENCODED);
			return template;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Writer initWriterStream(String className) throws Exception {
		try {
			File file = new File(className);
			if (!file .exists()  && !file .isDirectory()) {
				file .mkdir();
			}
			FileOutputStream fos = new FileOutputStream(className);
			Writer out = new OutputStreamWriter(fos, ENCODED);
			return out;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getTargetPath(String c_name) {
		String t_path = "";
		try {
			RequestMapping requestMapping = Class.forName(
					CONTROLLER_PATH + "." + c_name + "Controller")
					.getAnnotation(RequestMapping.class);
			String[] rs = requestMapping.value();
			for (String path : rs) {
				t_path = t_path + path;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return t_path;
	}

}
