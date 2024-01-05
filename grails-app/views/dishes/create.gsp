<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'dishes.label', default: 'Dishes')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
    <div id="content" role="main">
        <div class="container">
            <section class="row">
                <a href="#create-dishes" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
                
            </section>
            <section class="row">
                <div id="create-dishes" class="col-12 content scaffold-create" role="main">
                    <h1>image do not exceed 128000byes</h1>
                    <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <g:hasErrors bean="${this.dishes}">
                    <ul class="errors" role="alert">
                        <g:eachError bean="${this.dishes}" var="error">
                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                        </g:eachError>
                    </ul>
                    </g:hasErrors>
                    <g:uploadForm resource="${this.dishes}" method="POST">
                        <fieldset class="form">
                            <f:all bean="dishes"/>
                        </fieldset>
                        <input type='hidden' name='category' value='${params.category}'>
                        <div style='margin-left:25%'>      <g:each in='${menu.Filter.findAllByCategory(menu.Category.get(params.category))}' var='f'>
                       ${f.name}: <g:select name="${f.name}" from="${menu.Option.findAllByFilter(f)}" value="${name}"
        />
                        </g:each>
                        </div>
                        <fieldset class="buttons">
                            <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                        </fieldset>
                    </g:uploadForm>
                </div>
            </section>
        </div>
    </div>
    </body>
</html>
